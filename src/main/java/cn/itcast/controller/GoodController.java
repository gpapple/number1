package cn.itcast.controller;


import cn.itcast.domain.Goods;
import cn.itcast.domain.Type;
import cn.itcast.service.GoodsService;
import cn.itcast.service.TypeService;
import cn.itcast.utils.FileUtils;
import cn.itcast.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

@Controller
public class GoodController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TypeService typeService;

    @RequestMapping("/queryGoodsAll.do")
    public String queryGoodsAll(Model model, @RequestParam(defaultValue = "1")Integer pageNum, String gname, String starttime, String endtime) {
        int totalRecords = goodsService.queryGoodsnum();
        PageUtil page = new PageUtil(totalRecords, pageNum);
        HashMap<String, Object> map = new HashMap<>();
        map.put("gname",gname);
        map.put("starttime",starttime);
        map.put("endtime",endtime);
        map.put("startIndex", page.getStartIndex());
        map.put("pageSize", page.getPageSize());

        List<Goods> goods = goodsService.queryGoodsAll(map);

        page.setList(goods);
        model.addAttribute("page", page);
        model.addAttribute("map",map);
        return "goods_list";
    }

    @RequestMapping("/queryTypeAll.do")
    @ResponseBody
    public List<Type> queryTypeAll() {
        List<Type> list = typeService.queryTypeAll();
//        System.out.println(list);
        return list;
    }

    @RequestMapping("/addgoods.do")
    public String addgoods(Goods goods, MultipartFile file) throws IllegalStateException, IOException {
        String upload = FileUtils.upload(file);
        goods.setImage(upload);
        goodsService.addgoods(goods);
        return "redirect:queryGoodsAll.do";
    }

    @RequestMapping("/lookImg.do")
    @ResponseBody
    public void getImagesId(String imgPath, HttpServletResponse rp) {
        File imageFile = new File(imgPath);
        if (imageFile.exists()) {
            FileInputStream fis = null;
            OutputStream os = null;
            try {
                fis = new FileInputStream(imageFile);
                os = rp.getOutputStream();
                int count = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                    os.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @RequestMapping("/deleteGoodsById.do")
    @ResponseBody
    public Boolean deleteGoodsById(Integer gid){
        Boolean flg = goodsService.deleteGoodsById(gid);
        return flg;
    }

    @RequestMapping("/deleteAll.do")
    @ResponseBody
    public String  delelteAll(String gids){
        String[] g = gids.split(",");
        goodsService.delelteAll(g);
        return "ok";
    }

    @RequestMapping("/queryGoodsById.do")
    public String queryGoodsById(Model model,Integer gid) {
        Goods goods = goodsService.queryGoodsById(gid);
        System.out.println(goods);
        model.addAttribute("goods",goods);
        return "goods_update";
    }

    @RequestMapping("/updateGoods.do")
    public String updateGoods(Model model,Goods goods, MultipartFile file) throws IOException {
        String upload = FileUtils.upload(file);
        goods.setImage(upload);
        Boolean flg = goodsService.updateGoods(goods);
        if(flg){
            return "redirect:queryGoodsAll.do";
        }
        model.addAttribute("goods",goods);
        return "goods_update";
    }
}