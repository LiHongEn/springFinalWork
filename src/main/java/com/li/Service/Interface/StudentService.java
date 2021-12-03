package com.li.Service.Interface;

/*
* service层负责对Dao层数据的限制，比如我从dao层拿到的数据是否合法，等等操作
*
* */

import com.li.pojo.Student;

import java.util.List;

public interface StudentService {
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
