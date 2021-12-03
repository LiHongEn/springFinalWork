package com.li.GUI;

import com.li.Controller.StudentController;
import com.li.Mapper.Impl.StudentMapperImpl;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.List;

import com.li.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QueryPanel extends JPanel {

    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("applicationContext.xml");
    private static final StudentController studentController = (StudentController)CONTEXT.getBean("studentController");
//    private static final StudentMapperImpl studentDaoimpl = (StudentMapperImpl)CONTEXT.getBean("studentController");
//    private static final StudentMapper studentDao = (StudentMapper)CONTEXT.getBean("studentController");
    StudentMapperImpl studentDaoimpl= CONTEXT.getBean(StudentMapperImpl.class);



    private JTable table;
    private DefaultTableModel model;// 用于存储表格数据
    private String oldValue = "";// 保存单元格编辑 前的值

    /**
     * Create the panel.
     */
    public QueryPanel() {
        setLayout(new BorderLayout(0, 0));

        final JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);

        table = new JTable();

        scrollPane.setColumnHeaderView(table);
        // 初始化存储表格数据的对象
        model = new DefaultTableModel(new Object[][] {}, new String[] { "id",
                "name", "major", "phone" });
        // 将数据绑定到对象中
        table.setModel(model);
        table.setRowHeight(30);

        scrollPane.setViewportView(table);

        loadData();
        // 为表格绑定修改值后的事件
        model.addTableModelListener(new TableModelListener() {

//            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() < 0)
                    return;
                String nVal = table.getValueAt(e.getLastRow(), e.getColumn())
                        .toString();
                // 如果旧的值 和新的值一样，直接 返回
                if (nVal.equals(oldValue)) {
                    return;
                }
                // 判断当前编辑的单元格是否是主键列
                if (e.getColumn() == 0) {
                    // 还原旧的值
                    table.setValueAt(oldValue, e.getLastRow(), e.getColumn());
                    return;
                }
                // 更新数据
                Student student = new Student();
                student.setId(Integer.valueOf(table.getValueAt(e.getLastRow(),
                        0).toString()));
                student.setName(table.getValueAt(e.getLastRow(), 1).toString());
                student.setMajor(table.getValueAt(e.getLastRow(), 2).toString());
                student.setPhone(table.getValueAt(e.getLastRow(), 3).toString());
                System.out.println("============");
//                student.set
//                userDao.update(user);
                studentDaoimpl.UpdataStudent(student);
                loadData();
            }
        });
    }

    public void loadData() {
        // 清除旧的数据
        model.getDataVector().clear();
        // 查询部门数据
//        StudentMapperImpl studentDao = new StudentMapperImpl();
        System.out.println("==============");
//        java.util.List<Student> deptList = studentDaoimpl.findAllStudent();
        System.out.println(studentDaoimpl.findAllStudent());
        if(null == studentDaoimpl.findAllStudent() || studentDaoimpl.findAllStudent().size() ==0 ){
            System.out.println("他是空");
        }

        List<Student> deptList = studentDaoimpl.findAllStudent();
        System.out.println("==============");
        JComboBox cob = new JComboBox(deptList.toArray());
        // 创建一个使用下拉框代替编辑框的单元格对象
//        DefaultCellEditor dept = new DefaultCellEditor(cob);
        // 获取表格的列model对象
        TableColumnModel col = table.getColumnModel();
        // 获取部门的列，设置这个列为下拉框列类型
//        col.getColumn(2).setCellEditor(dept);
        // 查询所有的用户信息
//        java.util.List<User> list = userDao.queryAll();
        java.util.List<Student> list = studentController.findAll();
        System.out.println(list);
        // 遍历每一条数据，添加到model中
        for (Student student :list){
            cob.setSelectedItem(new Student());
            model.addRow(new Object[] { student.getId(), student.getName(),
                    student.getMajor(), student.getPhone() });
            System.out.println(student.getMajor()+student.getPhone());
        }

    }

    public void del() {
        if (table.getSelectedRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "请选择要删除的数据行");
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "是否确定要删除");
        // 判断用户是否点击
        if (result == JOptionPane.OK_OPTION) {
            int userid = Integer.valueOf(table.getValueAt(
                    table.getSelectedRow(), 0).toString());
            studentController.deleteStudent(userid);
            loadData();
        }
    }

}

