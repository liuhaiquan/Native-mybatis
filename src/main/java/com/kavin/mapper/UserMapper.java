package com.kavin.mapper;
import com.kavin.pojo.User;


/**
 * 编写规则
 *方法不能重载   包名+类名+方法名 确定一个MappedStatement
 * 1、包名+类名   =========    serMapper.xml 中 namespace值
 * 2. 方法名   ==========  serMapper.xml 中 sql语句对应标签的id值
 * 3. 方法参数   ===========   serMapper.xml 中 sql语句对应标签的parameterType值
 * 4. 方法返回值   ===========   serMapper.xml 中 sql语句对应标签的resultType值
 * */
public interface UserMapper {

    public User getUserByUserCode(String UserCode);

    public void saveUser(User user);
}
