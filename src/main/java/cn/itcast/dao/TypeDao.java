package cn.itcast.dao;

import cn.itcast.domain.Goods;
import cn.itcast.domain.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDao {

    List<Type> queryTypeAll();

}
