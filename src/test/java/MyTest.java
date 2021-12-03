import com.li.Controller.StudentController;
import com.li.Mapper.Interface.StudentMapper;
import com.li.Service.Interface.StudentService;
import com.li.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void Question4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentMapper studentDao = (StudentMapper) applicationContext.getBean("studentDao");

        Student student = new Student();
        student.setName("li");
        student.setMajor("eat");
        student.setPhone("17692954417");
        int num = studentDao.addStudent(student);
        if (num==1){
            System.out.println("添加成功");
        }else if(num==66){
            System.out.println("手机号格式有误！");
        }
    }

    @Test
    public void Question5(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentService studentService = (StudentService) applicationContext.getBean("studentService");

        Student student = new Student();
        student.setName("li");
        student.setMajor("eat");
        student.setPhone("1505791447");
        int num = studentService.addStudent(student);
        if (num==1){
            System.out.println("添加成功");
        }else if(num==66){
            System.out.println("手机号格式有误！");
        }
    }

    @Test
    public void Question6(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentController studentController = (StudentController) applicationContext.getBean("studentController");

        Student student = new Student();
        student.setName("sun");
        student.setMajor("eat");
        student.setPhone("1505791447");
        int num = studentController.addStudent(student);
        if (num==1){
            System.out.println("添加成功");
        }else if(num==66){
            System.out.println("手机号格式有误！");
        }
    }

    @Test
    public void Question7(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentDao = (StudentMapper) applicationContext.getBean("studentDao");
        List<Student> list = studentDao.findAllStudent();
        for (Student stu :
                list) {
            System.out.println(stu);
        }
    }
    @Test
    public void Question8(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        List<Student> list = studentService.findAllStudent();
        for (Student stu :
                list) {
            System.out.println(stu);
        }
    }
    @Test
    public void Question9(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentController studentController = (StudentController) applicationContext.getBean("studentController");
        List<Student> list = studentController.findAll();
        for (Student stu :
                list) {
            System.out.println(stu);
        }
    }
    @Test
    public void Question11(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentDao = (StudentMapper) applicationContext.getBean("studentDao");
        int num =studentDao.DeleteStudent(5);
        if (num==0){
            System.out.println("未找到！");
        }else {
            System.out.println("成功删除");
        }
    }
    @Test
    public void Question12(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        int num =studentService.DeleteStudent(5);
        if (num==0){
            System.out.println("未找到！");
        }else {
            System.out.println("成功删除");
        }
    }
    @Test
    public void Question13(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentController studentController = (StudentController) applicationContext.getBean("studentController");
        int num =studentController.deleteStudent(5);
        if (num==0){
            System.out.println("未找到！");
        }else {
            System.out.println("成功删除");
        }
    }

    @Test
    public void Question14(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentDao = (StudentMapper) applicationContext.getBean("studentDao");
        Student student = studentDao.QUeryStudentById(1);
        System.out.println(student);
    }
    @Test
    public void Question15(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        Student student = studentService.QUeryStudentById(1);
        System.out.println(student);
    }
    @Test
    public void Question16(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentController studentController = (StudentController) applicationContext.getBean("studentController");
        Student student = studentController.QUeryStudentByID(1);
        System.out.println(student);
    }
    @Test
    public void Question17(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentDao = (StudentMapper) applicationContext.getBean("studentDao");
        Student student = new Student();
        student.setId(2);
        student.setName("sun");
        student.setMajor("eat");
        student.setPhone("1505791447");
        int num = studentDao.UpdataStudent(student);
        if (num==0){
            System.out.println("未找到！");
        }else if (num==66){
            System.out.println("手机号有误");
        }else{
            System.out.println("修改成功");
        }

    }
    @Test
    public void Question18(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        Student student = new Student();
        student.setId(2);
        student.setName("li");
        student.setMajor("eat");
        student.setPhone("1505791447");
        int num = studentService.UpdataStudent(student);
        if (num==0){
            System.out.println("未找到！");
        }else if (num==66){
            System.out.println("手机号有误");
        }else{
            System.out.println("修改成功");
        }
    }
    @Test
    public void Question19(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentController studentController = (StudentController) applicationContext.getBean("studentController");
        Student student = new Student();
        student.setId(2);
        student.setName("sun");
        student.setMajor("eat");
        student.setPhone("17692954417");
        int num = studentController.updataStudent(student);
        if (num==0){
            System.out.println("未找到！");
        }else if (num==66){
            System.out.println("手机号有误");
        }else{
            System.out.println("修改成功");
        }
    }
}
