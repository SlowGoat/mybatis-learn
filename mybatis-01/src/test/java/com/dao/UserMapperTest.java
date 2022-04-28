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

    @Test
    public void testGetUserLike() {

        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            // 方式一：getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 需要拼接通配符 %
//            List<User> userList = userMapper.getUserLike("%五%");
            List<User> userList = userMapper.getUserLike("五");

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

    @Test
    public void testGetUserById() {

        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(2);
            System.out.println(user);

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testGetUserByIdUseMap() {

        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            Map<String, Object> map = new HashMap<>();
            map.put("userId", 5);
            map.put("userName", "小五");

            User user = userMapper.getUserByIdUseMap(map);
            System.out.println(user);

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    // 增删改 必需要 提交事务
    @Test
    public void testAddUser() {

        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int res = userMapper.addUser(new User(3, "小小", "123"));

            if(res > 0) System.out.println("插入成功！");

            // 提交事务
            sqlSession.commit();

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    // 增删改 必需要 提交事务
    @Test
    public void testAddUserUseMap() {

        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            Map<String, Object> map = new HashMap<>();
            map.put("userId", 5);
            map.put("userName", "小五");
            map.put("userPwd", "123");

            int res = userMapper.addUserUseMap(map);

            if(res > 0) System.out.println("插入成功！");

            // 提交事务
            sqlSession.commit();

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    // 增删改 必需要 提交事务
    @Test
    public void testUpdateUser() {

        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int res = userMapper.updateUser(new User(3, "小小", "123456"));

            if(res > 0) System.out.println("修改成功！");

            // 提交事务
            sqlSession.commit();

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    // 增删改 必需要 提交事务
    @Test
    public void testDeleteUserById() {

        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int res = userMapper.deleteUserById(3);

            if(res > 0) System.out.println("删除成功！");

            // 提交事务
            sqlSession.commit();

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }
}
