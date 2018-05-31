package com.itxzxy.pojo;

/**
 *建立表格命令
 * DROP TABLE IF EXISTS `students`;
 CREATE TABLE `students` (
 `name` varchar(10) DEFAULT NULL,
 `QQ` varchar(15) DEFAULT NULL,
 `type` varchar(10) DEFAULT NULL,
 `admission_time` varchar(20) DEFAULT NULL,
 `school` varchar(10) DEFAULT NULL,
 `num` varchar(10) DEFAULT NULL,
 `daily` varchar(100) DEFAULT NULL,
 `declaration` varchar(50) DEFAULT NULL,
 `elder` varchar(30) DEFAULT NULL,
 `knew_from` varchar(10) DEFAULT NULL,
 `ID` bigint(20) NOT NULL AUTO_INCREMENT,
 `create_at` bigint(20) DEFAULT NULL,
 `update_at` bigint(20) DEFAULT NULL,
 PRIMARY KEY (`ID`),
 UNIQUE KEY `online` (`num`),
 KEY `name` (`name`)
 ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

 INSERT INTO `students` VALUES ('李大', '908163862', 'JAVA工程师', '20180808', '清华大学', 'java-1', 'http://www.jnshu.com/daily/40038?dailyType=others&total=8&page=1&uid=18143&sort=0&orderBy=3', '仙风道骨，high到入土！', '郑州分院王尼玛', '知乎', '1', null, null);
 INSERT INTO `students` VALUES ('李大', '908163862', 'JAVA工程师', '20180808', '清华大学', 'java-2', 'http://www.jnshu.com/daily/40038?dailyType=others&total=8&page=1&uid=18143&sort=0&orderBy=3', '仙风道骨，high到入土！', '郑州分院王尼玛', '知乎', '2', null, null);
 */

public class Student {

    public Student() {

    }

    public Student(String name, String qq, String type, String admissionTime, String school,
                   String num, String daily, String declaration, String elder, String knewFrom) {
        this.name = name;
        this.qq = qq;
        this.type = type;
        this.admissionTime = admissionTime;
        this.school = school;
        this.num = num;
        this.daily = daily;
        this.declaration = declaration;
        this.elder = elder;
        this.knewFrom = knewFrom;
    }

    private String name;
    private String qq;
    private String type;
    private String admissionTime;
    private String school;
    private String num;
    private String daily;
    private String declaration;
    private String elder;
    private String knewFrom;
    private long createAt;
    private long updateAt;
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQQ() {
        return qq;
    }

    public void setQQ(String qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(String admissionTime) {
        this.admissionTime = admissionTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getElder() {
        return elder;
    }

    public String getKnewFrom() {
        return knewFrom;
    }

    public void setKnewFrom(String knewFrom) {
        this.knewFrom = knewFrom;
    }

    public void setElder(String elder) {
        this.elder = elder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return ("姓名：" + name + "\nQQ：" + qq + "\n修真类型：" + type + "\n预计入学时间：" + admissionTime
                + "\n毕业院校：" + school + "\n线上学号：" + num + "\n日报链接：" + daily
                + "\n立愿：" + declaration + "\n辅导师兄：" + elder + "\n从何处了解：" + knewFrom);
    }

}