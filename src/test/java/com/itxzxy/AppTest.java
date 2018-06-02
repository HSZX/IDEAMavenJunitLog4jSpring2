package com.itxzxy;


import com.itxzxy.dao.StudentMapper;
import com.itxzxy.pojo.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private SqlSessionFactory sqlSessionFactory;


    @Before //创建会话工厂sqlSessionFactory
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml"; //mybatis配置文件
        //得到配置文件的流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂SqlSessionFactory,把mybaits的配置文件的流传入会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void findByIdTest() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.findById(1L);
        System.out.println(student);
    }

    @Test
    public void findByNameTest() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.findByName("王");
        System.out.println(students);
    }

    @Test
    public void findByNumTest() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.findByNum("java-5000");
        System.out.println(student);
    }

    @Test
    public void insertSingleTest() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Logger logger = Logger.getLogger(AppTest.class);
        Student student_insert = new Student(
                "儿子", "3169119846", "JAVA工程师",
                "20180531", "清华大学", "java-10",
                "http://www.jnshu.com/daily/40038?dailyType=others&total=8&page=1&uid=18143&sort=0&orderBy=3",
                "仙风道骨，high到入土", "马云", "知乎");

        student_insert.setCreateAt(System.currentTimeMillis());
        logger.debug(studentMapper.insertStudent(student_insert) + "  :  " + student_insert.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertStudentTest() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Logger logger = Logger.getLogger(App.class);
        long start_insert = System.currentTimeMillis();
        Student student_insert = new Student(
                "乖儿子", "3169119846", "JAVA工程师",
                "11月18日--11月22日", "燕山大学", "java-",
                "http://www.jnshu.com/daily/40038?dailyType=others&total=8&page=1&uid=18143&sort=0&orderBy=3",
                "努力努力再努力！", "郑州分院王鹏举", "知乎");
        student_insert.setCreateAt(System.currentTimeMillis());
        for (int i = 1; i < 11; i++) {
            student_insert.setNum("java-" + i);
            logger.debug(studentMapper.insertStudent(student_insert) + "  :  " + student_insert.getId());
        }
        long end_insert = System.currentTimeMillis();
        logger.info("The total time spent on updating is " + (end_insert - start_insert) + "millisecond.");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteStudentTest() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        System.out.println(studentMapper.deleteStudent(1L));
    }

    @Test
    public void updateStudentTest() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Logger logger = Logger.getLogger(AppTest.class);
        long start_update = System.currentTimeMillis();
        Student student_update = studentMapper.findById(3L);//取出原记录
        student_update.setUpdateAt(System.currentTimeMillis());
        student_update.setDeclaration("老大最帅");//准备新记录

        logger.debug(studentMapper.updateStudent(student_update));//将新记录送去数据库替换原纪录

        long end_update = System.currentTimeMillis();
        logger.info("The total time spent on updating is " + (end_update - start_update) + "millisecond.");
    }

    @Test
    public void updateAllTest() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Logger logger = Logger.getLogger(AppTest.class);
        long start = System.currentTimeMillis();
        Student student = new Student();
        student.setUpdateAt(System.currentTimeMillis());
        student.setDeclaration("老大最帅");
        logger.debug(studentMapper.updateStudent(student));
        long end = System.currentTimeMillis();
        logger.info("The total time spent on updating is " + (end - start) + "millisecond.");
    }

 @Test
    public void truncateTableTest() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.truncateTable();
        sqlSession.close();
    }

}
