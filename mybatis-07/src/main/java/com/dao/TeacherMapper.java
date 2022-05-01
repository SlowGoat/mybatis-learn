package com.dao;

import com.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> getTeachers();

    // 获取指定老师下的所有学生以及老师的信息
    Teacher getTeacherById(@Param("tid") int id);

    Teacher getTeacherById2(@Param("tid") int id);
}
