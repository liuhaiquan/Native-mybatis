package com.kavin.service;

import com.kavin.mapper.UserMapper;
import com.kavin.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {



    @Autowired     //sqlSessionTemplate 是线程安全的
    public SqlSessionTemplate sqlSessionTemplate;

    /**
     * 一级缓存测试方法
     * @return
     */
    public User oneCache(){
        /**
         * sqlSessionTemplate 不能使用一级缓存 案例
         */
        //注入的SqlSessionTemplate每次返回Mapper时会生成一个新的SqlSession
       UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);    //获取mapper代理对象
        //调用mapper代理对象的方法相当于直接调用配置文件中的UserMapper.xml 中的MappedStatement
        User user = null;
        for (int i= 0;i<3;i++){
            //sqlSessionTemplate.selectList("com.kavin.mapper.UserMapper.getUserByUserCode");
            user = userMapper.getUserByUserCode("");
        }

        /**
         * sqlSession使用一级缓存 案例
         */

/*       //直接使用defaultsqlsession 连接数据库,此处会用到一级缓存.
        SqlSession SqlSession =sqlSessionTemplate.getSqlSessionFactory().openSession();
        User user = null;
        for (int i= 0;i<3;i++){
             user=SqlSession.getMapper(UserMapper.class).getUserByUserCode("");
        }*/
        return user;
    }

    /**
     * 二级缓存测试方法
     */
    public void twoCache(){
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession();
        //得到接口
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.getUserByUserCode("");
        //此步骤是关键，如果不close。不会提交事务。提交事务之后才会从二级缓存中取结果
        session.close();
        session = sqlSessionTemplate.getSqlSessionFactory().openSession();
        System.out.println("二级缓存:第二次查询直接从缓存汇总拿了，没有发出sql语句:");
        UserMapper mapper2 = session.getMapper(UserMapper.class);
        mapper2.getUserByUserCode("");

    }



}
