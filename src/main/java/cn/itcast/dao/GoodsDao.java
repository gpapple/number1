package cn.itcast.dao;

import cn.itcast.domain.Goods;
import cn.itcast.domain.Type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface GoodsDao {

    public List<Goods> queryGoodsAll(HashMap<String, Object> map);

    void addgoods(Goods goods);

    void deleteGoodsById(Integer gid);


    Integer delelteAll(String[] g);

    Goods queryGoodsById(Integer gid);

    Integer updateGoods(Goods goods);

    int queryGoodsnum();
}
