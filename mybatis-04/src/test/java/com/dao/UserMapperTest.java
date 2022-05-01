package com.dao;

import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void test() {

        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            // 方式一：getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1);

            System.out.println(user);
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testLog4j() {
        logger.info("info: 进入了testLog4j");
        logger.debug("debug: 进入了testLog4j");
        logger.error("error: 进入了testLog4j");

    }

    @Test
    public void testGetUserByLimit() {
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            // 方式一：getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            Map<String, Integer> map = new HashMap<>();
            map.put("startIndex", 0);
            map.put("pageSize", 3);

            List<User> userList = userMapper.getUserByLimit(map);

            for (User user : userList) {
                System.out.println(user);
            }


        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testGetUserByRowBounds() {
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            // 通过RowBounds 实现
            RowBounds rowBounds = new RowBounds(0, 2);

            List<User> userList = sqlSession.selectList("com.dao.UserMapper.getUserByRowBounds", null, rowBounds);
            for (User user : userList) {
                System.out.println(user);
            }


        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }
}
