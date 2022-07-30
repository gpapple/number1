package cn.itcast.service.impl;

import cn.itcast.dao.TypeDao;
import cn.itcast.domain.Type;
import cn.itcast.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public List<Type> queryTypeAll() {
        return typeDao.queryTypeAll();
    }


    public static void main(String[] args) {
        String string = "5,6";
        String[] split = string.split(",");
        for (String s : split) {
            System.out.println(s);
        }
    }


}
