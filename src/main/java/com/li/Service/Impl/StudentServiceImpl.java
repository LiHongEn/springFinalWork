package com.li.Service.Impl;

import com.li.Mapper.Interface.StudentMapper;
import com.li.Service.Interface.StudentService;
import com.li.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentDao;

    public int addStudent(Student student) {
        if (isPhone(student.getPhone())){
            int num = studentDao.addStudent(student);
            return num;
        }
        return 66;//手机号有误
    }

    public List<Student> findAllStudent() {
        List<Student> list = studentDao.findAllStudent();
        return list;
    }

    public int DeleteStudent(Integer id) {
        int num = studentDao.DeleteStudent(id);
        return num;
    }

    public Student QUeryStudentById(Integer id) {
        Student student = studentDao.QUeryStudentById(id);
        return student;
    }

    public int UpdataStudent(Student student) {
        if (isPhone(student.getPhone())){
            int num = studentDao.UpdataStudent(student);
            return num;
        }
        else {
            return 66;//手机号有误
        }
    }

    public boolean isPhone(String PhoneNum){
        Pattern pattern = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(PhoneNum);
        return  matcher.matches();

    }

}
