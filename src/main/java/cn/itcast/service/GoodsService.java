package cn.itcast.service;

import cn.itcast.domain.Goods;
import cn.itcast.domain.Type;

import java.util.HashMap;
import java.util.List;

public interface GoodsService {

    public List<Goods> queryGoodsAll(HashMap<String, Object> map);

    void addgoods(Goods goods);

    Boolean deleteGoodsById(Integer gid);

    Integer delelteAll(String[] g);

    Goods queryGoodsById(Integer gid);

    Boolean updateGoods(Goods goods);


    int queryGoodsnum();
}

