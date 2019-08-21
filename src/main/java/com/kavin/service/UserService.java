package com.kavin.service;

import com.kavin.mapper.UserMapper;
import com.kavin.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired      //sqlSessionTemplate 是线程安全的
    public SqlSessionTemplate sqlSessionTemplate;


    public User getUserByUserCode(){
        //获取mapper代理对象
        UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
        //调用mapper代理对象的方法相当于直接调用配置文件中的UserMapper.xml 中的MappedStatement
        User user = userMapper.getUserByUserCode("");
        System.out.println(user);
        return user;
    }

}
