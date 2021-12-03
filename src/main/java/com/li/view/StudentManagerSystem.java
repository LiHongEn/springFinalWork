package com.li.view;

import com.li.Controller.StudentController;
import com.li.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class StudentManagerSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("applicationContext.xml");
    private static final StudentController studentController = (StudentController)CONTEXT.getBean("studentController");

    public static void main(String[] args) {
        select();
    }

    public static void addStudent() {
        System.out.println("请输入学生姓名：");
        String studentname=scanner.next();
        System.out.println("请输入学生专业：");
        String jobs=scanner.next();
        System.out.println("请输入学生手机号：");
        String phone=scanner.next();
        Student student = new Student();
        student.setName(studentname);
        student.setMajor(jobs);
        student.setPhone(phone);
        int num=studentController.addStudent(student);
        if (num==1){
            System.out.println("添加成功");
        }else if(num==66){
            System.out.println("手机号格式有误！");
            addStudent();
        }
    }
    public static void deleteStudent(){
        System.out.println("请输入要删除同学的id：");
        int id = scanner.nextInt();
        int num =studentController.deleteStudent(id);
        if (num==0){
            System.out.println("未找到！");
            deleteStudent();
        }else {
            System.out.println("成功删除");
        }
    }

    public static void updateStudent(){
        System.out.println("请输入学生id：");
        Integer id=scanner.nextInt();
        Student student1 = studentController.QUeryStudentByID(id);
        System.out.println(student1);
        System.out.println("请输入修改后学生姓名：");
        String studentname=scanner.next();
        System.out.println("请输入修改后学生专业：");
        String jobs=scanner.next();
        System.out.println("请输入修改后学生手机号：");
        String phone=scanner.next();
        Student student = new Student();
        student.setId(id);
        student.setName(studentname);
        student.setMajor(jobs);
        student.setPhone(phone);
        int num = studentController.updataStudent(student);
        if (num==0){
            System.out.println("未找到！");
            updateStudent();
        }else if (num==66){
            System.out.println("手机号有误");
            updateStudent();
        }else{
            System.out.println("修改成功");
        }
    }

    public static void findAllStudent(){
        List<Student> list = studentController.findAll();
        for (Student stu :
                list) {
            System.out.println(stu);
        }
    }

    public static void findStudentById(){
        System.out.println("请输入学生id：");
        Integer id=scanner.nextInt();
        Student student = studentController.QUeryStudentByID(id);
        System.out.println(student);
    }

    public static void select(){
        System.out.println("1.增加学生信息");
        System.out.println("2.删除学生信息");
        System.out.println("3.更新学生信息");
        System.out.println("4.查找学生信息");
        System.out.println("5.按id查找学生信息");
        System.out.println("0.退出");
        int i = scanner.nextInt();
        if (i==1){
            addStudent();
            select();
        }else if(i==2){
            deleteStudent();
            select();
        }else if (i==3){
            updateStudent();
            select();
        }else if (i==4){
            findAllStudent();
            select();
        }else if (i==5){
            findStudentById();
            select();
        }else if (i==0){
            return;
        } else {
            System.out.println("输入错误！");
            select();
        }
    }
}
