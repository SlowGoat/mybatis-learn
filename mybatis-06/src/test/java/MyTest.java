import com.dao.StudentMapper;
import com.dao.TeacherMapper;
import com.pojo.Student;
import com.pojo.Teacher;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void testGetTeacherById() {
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            // 方式一：getMapper
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = teacherMapper.getTeacherById(1);
            System.out.println(teacher);

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testGetStudents() {
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            // 方式一：getMapper
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = studentMapper.getStudents();
            for (Student student : studentList) {
                System.out.println(student);
            }

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testGetStudents2() {
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            // 方式一：getMapper
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = studentMapper.getStudents2();
            for (Student student : studentList) {
                System.out.println(student);
            }

        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }
}
