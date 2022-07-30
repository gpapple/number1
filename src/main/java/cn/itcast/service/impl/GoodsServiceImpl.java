package cn.itcast.service.impl;

import cn.itcast.dao.GoodsDao;
import cn.itcast.domain.Goods;
import cn.itcast.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> queryGoodsAll(HashMap<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
        return goodsDao.queryGoodsAll(map);
    }


    @Override
    public void addgoods(Goods goods) {
        goodsDao.addgoods(goods);
    }

    @Override
    public Boolean deleteGoodsById(Integer gid) {
        goodsDao.deleteGoodsById(gid);
        return gid>0?true:false;
    }

    @Override
    public Integer delelteAll(String[] g) {
        return goodsDao.delelteAll(g);
    }

    @Override
    public Goods queryGoodsById(Integer gid) {
        return goodsDao.queryGoodsById(gid);
    }

    @Override
    public Boolean updateGoods(Goods goods) {
        Integer num = goodsDao.updateGoods(goods);
        return num!=-2?true:false;
    }

    @Override
    public int queryGoodsnum() {
        return goodsDao.queryGoodsnum();
    }


}
