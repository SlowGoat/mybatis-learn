package com.dao;

import com.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 查询全部用户
    List<User> getUserList();

    // 模糊查询
    List<User> getUserLike(String value);

    // 根据ID查询用户
    User getUserById(int id);

    // 根据ID查询用户
    User getUserByIdUseMap(Map<String, Object> map);

    // 新增一个用户
    int addUser(User user);

    // 万能的map
    int addUserUseMap(Map<String, Object> map);

    // 修改用户
    int updateUser(User user);

    // 删除一个用户
    int deleteUserById(int id);
}
