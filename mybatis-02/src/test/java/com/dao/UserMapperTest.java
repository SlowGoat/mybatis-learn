package com.dao;

import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void test() {

        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            // 方式一：getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();

            // 方式二： (不建议使用)
            // List<User> userList = sqlSession.selectList("com.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

}
