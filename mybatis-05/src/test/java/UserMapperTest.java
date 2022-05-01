import com.dao.UserMapper;
import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void testGetUsers() {

        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            // 方式一：getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUsers();
            for (User user : userList) {
                System.out.println(user);
            }

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testGetUserByIdAndName() {

        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserByIdAndName(5, "小五");
            System.out.println(user);
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testAddUser() {
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.addUser(new User(6, "小六", "123"));

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateUser() {
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateUser(new User(6, "小六", "666666"));

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteUser() {
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(6);

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }
}
