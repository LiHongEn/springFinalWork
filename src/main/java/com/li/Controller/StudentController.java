package com.li.Controller;

import com.li.Service.Interface.StudentService;
import com.li.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    public int addStudent(Student student){
        int num = studentService.addStudent(student);
        return num;
    }

    public List<Student> findAll(){
        List<Student> list = studentService.findAllStudent();
        return list;
    }

    public Student QUeryStudentByID(Integer id){
        Student student = studentService.QUeryStudentById(id);
        return student;
    }

    public int deleteStudent(Integer id) {
        int num = studentService.DeleteStudent(id);
        return num;
    }

    public int updataStudent(Student student){
        int num = studentService.UpdataStudent(student);
        return num;
    }

}
