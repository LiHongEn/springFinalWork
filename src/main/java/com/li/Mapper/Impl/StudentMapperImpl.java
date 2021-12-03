package com.li.Mapper.Impl;

import com.li.Mapper.Interface.StudentMapper;
import com.li.pojo.Student;
//import com.li.org.apache.xalan.internal.xsltc.compiler.Template;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;

@Repository("studentDao")
public class StudentMapperImpl extends SqlSessionDaoSupport implements StudentMapper {
    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public int addStudent(Student student) {
        return getSqlSession().getMapper(StudentMapper.class).addStudent(student);
    }

    public List<Student> findAllStudent() {
        return getSqlSession().getMapper(StudentMapper.class).findAllStudent();
    }

    public int DeleteStudent(Integer id) {
        return getSqlSession().getMapper(StudentMapper.class).DeleteStudent(id);
    }

    public Student QUeryStudentById(Integer id) {
        return getSqlSession().getMapper(StudentMapper.class).QUeryStudentById(id);
    }

    public int UpdataStudent(Student student) {
        return getSqlSession().getMapper(StudentMapper.class).UpdataStudent(student);
    }


//    public int addStudent(Student student) {
//        String sql = "insert into studentsimformation values(?,?,?,?);";
//        Object[] objects = new Object[]{
//                student.getId(),
//                student.getName(),
//                student.getMajor(),
//                student.getPhone()
//        } ;
//        int num= jdbcTemplate.update(sql,objects);
//        return num;
//    }
//
//    public List<Student> findAllStudent() {
//        String sql = "select * from studentsimformation;";
//        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
//        List <Student> list = jdbcTemplate.query(sql,rowMapper);
//        return list;
//    }
//
//    public int DeleteStudent(Integer id) {
//        String sql = "delete from studentsimformation where id =?;";
//        int num = jdbcTemplate.update(sql,id);
//        return num;
//    }
//
//    public Student QUeryStudentById(Integer id) {
//        String sql ="select * from studentsimformation where id = " + id;
//        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
//        Student student = jdbcTemplate.queryForObject(sql,rowMapper);
//        return student;
//    }
//
//    public int UpdataStudent(Student student) {
//        String sql = "update studentsimformation set name = ?,major = ?,phone = ? where id = ?";
//        Object[] obj = new Object[]{student.getName(),student.getMajor(),student.getPhone(),student.getId()};
//        int num= jdbcTemplate.update(sql,obj);
//        return num;
//    }
}
