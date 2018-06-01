package com.itxzxy;

import com.itxzxy.pojo.Student;
import com.itxzxy.service.CrudService;
import com.itxzxy.service.CrudServiceImpl;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(App.class);

        CrudService service = new CrudServiceImpl();

        Student studentInsert = new Student(
                "李弘基", "908163862", "JAVA工程师",
                "20180808", "清华大学", "java-3",
                "http://www.jnshu.com/daily/40038?dailyType=others&total=8&page=1&uid=18143&sort=0&orderBy=3",
                "仙风道骨，high到入土！", "成都分院王尼玛", "知乎");
        //插入数据，可以加个循环插入n条数据
        // 插入数据时候num必须互不相同，因为设计的表格num建立了唯一索引
        // 记录debug级别的信息
/*
        try {

            service.addAStudent(studentInsert);
            logger.debug("->成功插入一条信息");
        } catch (Exception e) {
            logger.error("->插入信息时发生错误！");
        }

        //删除

        try {
            long deleteId = 1;
            if (service.deleteAStudent(deleteId)) {
                logger.info("->成功删除一条学员信息，该学员的ID是" + deleteId);
            } else {
                logger.info("->删除失败，ID为" + deleteId + "的学员不存在！");
            }
        } catch (Exception e) {
            logger.error("->删除信息时发生错误！");
        }

        //使用学号精确查询
        try {
            String selectNum = "java-5";
            Student studentByNum;
            studentByNum = service.findAStudentByNum(selectNum);
            if (studentByNum != null) {
                logger.info("->成功找到线上学号为“" + selectNum + "”的学员：\n" + studentByNum);
            } else {
                logger.info("->查询失败，线上学号为" + selectNum + "的学员不存在！");
            }
        } catch (Exception e) {
            logger.error("->查询的时候发生错误！");
        }
        */

        //主键查询
        try {
            Long selectID = 1L;
            Student studentByID;
            studentByID = service.findByPrimeKey(selectID);
            if (studentByID != null)
                logger.info("->成功找到ID为“" + selectID + "”的学员：\n" + studentByID);
            else
                logger.info("->查询失败，ID为" + selectID + "的学员不存在！");
        } catch (Exception e) {
            logger.info("->查询的时候发生错误！");
        }
/*
        //逐条更新
        long startUpdate = System.currentTimeMillis();
        Student studentUpdate = studentInsert;
        studentUpdate.setDeclaration("老大最帅");
        //不更新Num属性
        studentUpdate.setNum(null);
        for (long i = 1; i < 10; i++) {
            studentUpdate.setId(i);
            try {
                if (service.updateInformation(studentUpdate)) {
                    logger.debug("->ID为" + i + "的学员信息更新成功！");
                } else {
                    logger.info("->ID为" + i + "的学员信息更新失败！");
                }
            } catch (Exception e) {
                logger.error("->更新的时候发生异常！");
            }
        }
        long endUpdate = System.currentTimeMillis();
        logger.info("->完成更新！一共花费时间： " + (endUpdate - startUpdate) + "毫秒。");

        //清空表格，为下次测试做准备
        try {
            service.deleteAll();
            logger.info("表格数据清理成功，随时可以进行下一次测试！");
        } catch (Exception e) {
            logger.error("->清理的时候发生错误！");
        }
        */
    }

}
