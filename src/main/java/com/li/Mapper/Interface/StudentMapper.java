package com.li.Mapper.Interface;

import com.li.pojo.Student;

import java.util.List;
/*
* 到层负责对数据库的操作即执行SQL语句
*
* */

public interface StudentMapper {
    /**
     *添加学生方法
     * @param student
     * @return
     */
    int addStudent(Student student);

    /**
     * 查找全部学生方法
     * @return
     */
    List<Student> findAllStudent();

    /**
     * 根据id删除学生信息方法  其中id为主键
     * @param id
     * @return
     */
    int DeleteStudent(Integer id);

    /**
     *根据id查询学生信息方法  其中id为主键
     * @param id
     * @return
     */
    Student QUeryStudentById(Integer id);

    /**
     * 更新学生信息方法
     * @param student
     * @return
     */
    int UpdataStudent(Student student);

}
