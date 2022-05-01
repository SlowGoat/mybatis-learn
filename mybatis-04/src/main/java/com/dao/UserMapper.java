package com.dao;

import com.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    // 根据ID查询用户
    User getUserById(int id);

    // limit 实现分页
    List<User> getUserByLimit(Map<String, Integer> map);

    // RowBounds 实现分页
    List<User> getUserByRowBounds();
}
