package com.li.GUI;

import com.li.Controller.StudentController;
import com.li.Mapper.Impl.StudentMapperImpl;
import com.li.Mapper.Interface.StudentMapper;
import com.li.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddPanel extends JPanel {
    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("applicationContext.xml");
    private static final StudentController studentController = (StudentController)CONTEXT.getBean("studentController");
    //    private static final StudentMapperImpl studentDaoimpl = (StudentMapperImpl)CONTEXT.getBean("studentController");
//    private static final StudentMapper studentDao = (StudentMapper)CONTEXT.getBean("studentController");
    StudentMapperImpl studentDaoimpl= CONTEXT.getBean(StudentMapperImpl.class);
    private JTextField txtID;
    private JTextField txtName;
    private JTextField txtMajor;
    private JTextField txtphone;

    private JComboBox cmbDept;
    private StudentMapper studentDao;

//    private IUserDao userDao;
//    private IDpetDao deptDao;
//    private Student student;
    private QueryPanel query;
    private Frame main;
    /**
     * Create the panel.
     */
    public AddPanel() {
        setLayout(null);

        //id
        JLabel label = new JLabel("id：");
        label.setBounds(86, 60, 54, 15);
        add(label);

        txtID = new JTextField();
        txtID.setBounds(150, 60, 146, 18);
        add(txtID);
        txtID.setColumns(10);


        //name
        JLabel label_1 = new JLabel("name：");
        label_1.setBounds(86, 100, 54, 15);
        add(label_1);

        txtName = new JTextField();
        txtName.setBounds(150, 100, 146, 18);
        add(txtName);
        txtName.setColumns(10);

//        userDao=new UserDaoImpl();
//        deptDao=new DeptDaoImpl();
//        student = new StudentMapperImpl();

        List<Student> list=studentDaoimpl.findAllStudent();

//下拉框
//        cmbDept = new JComboBox(list.toArray());
//        cmbDept.setBounds(150, 110, 146, 23);
//        add(cmbDept);

        //major标签和文本框
        JLabel label_2 = new JLabel("major：");
        label_2.setBounds(86, 140, 54, 15);
        add(label_2);

        txtMajor = new JTextField();
        txtMajor.setBounds(150, 140, 146, 18);
        add(txtMajor);
        txtMajor.setColumns(10);


        //phone
        JLabel label_3 = new JLabel("phone：");
        label_3.setBounds(86, 180, 54, 15);
        add(label_3);

        txtphone = new JTextField();
        txtphone.setBounds(150, 180, 146, 18);
        add(txtphone);
        txtphone.setColumns(10);


        JButton btnNewButton = new JButton("添加用户");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String s_id=txtID.getText();
                int i_id = Integer.parseInt(s_id);
                String s_major=txtMajor.getText();
                String s_name = txtName.getText();
                String s_phone = txtphone.getText();
//                Dept dept=(Dept) cmbDept.getSelectedItem();
//                User user=new User();
//                user.setBirth(birth);
//                user.setName(name);
//                user.setDeptid(dept.getDeptid());
//                Student student = (Student) cmbDept.getSelectedItem();
                Student student =new Student();
                student.setId(i_id);
                student.setName(s_name);
                student.setMajor(s_major);
                student.setPhone(s_phone);
//                if(userDao.add(user)){
//                    JOptionPane.showMessageDialog(null, "插入成功");
//                    txtName.setText("");
//                    txtBirth.setText("");
//
//                }else{
//                    JOptionPane.showMessageDialog(null, "插入失败");
//                }
                if (studentDaoimpl.addStudent(student)>0){
                    JOptionPane.showMessageDialog(null, "插入成功");
                    txtID.setText("");
                    txtName.setText("");
                    txtMajor.setText("");
                    txtphone.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null, "插入失败");
                }
            }
        });
        btnNewButton.setBounds(150, 217, 116, 23);
        add(btnNewButton);
    }
}