package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

//    关于@Param注解
//    1. 基本类型得参数或者String类型，需要加上
//    2. 引用类型不需要加
//    3. 如果只有一个基本类型的话，可以忽略，但是建议加上
//    4. 我们在xml sql 中引用的参数就是 这里的@Param() 中设置的属性名

//    @Select("select * from user")
    @Select("select id, name, pwd as password from user")
    List<User> getUsers();

    // 方法存在多个参数，所有得参数前面必须加上 @Param 注解
    @Select("select * from user where id = #{idhello} and name = #{name}")
    User getUserByIdAndName(@Param("idhello") int id, @Param("name") String name);

    @Insert("insert into user(id, name, pwd) value (#{id}, #{name}, #{password})")
    int addUser(User user);

    @Update("update user set name=#{name}, pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);
}
