package com.example;

import com.example.Util.MybatisUtil;
import com.example.entily.Classcj;
import com.example.entily.Student;
import com.example.mapper.ClassMapper;
import com.example.mapper.Classcj2Mapper;
import com.example.mapper.ClasscjMapper;
import com.example.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try (SqlSession sqlSession = MybatisUtil.getSession(true)) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);//用接口来访问 自带的getMapper方法来得到一个接口class
            ClassMapper mapper1 = sqlSession.getMapper(ClassMapper.class);
            ClasscjMapper mapper2 = sqlSession.getMapper(ClasscjMapper.class);
            Classcj2Mapper mapper3 = sqlSession.getMapper(Classcj2Mapper.class);
            boolean n = true;
            while (n) {
                System.out.println("学生信息管理:1");
                System.out.println("课程信息管理:2");
                System.out.println("学生成绩管理:3");
                System.out.println("学生成绩计算:4");
                System.out.println("学生成绩2管理:5");
                System.out.println("想退出请按:9");
                Scanner scan = new Scanner(System.in);
                int num1 = scan.nextInt();
                if (num1 == 1) {
                    boolean t = true;
                    while (t) {
                        System.out.println("新增学生信息:1");
                        System.out.println("修改学生信息:2");
                        System.out.println("删除学生信息:3");
                        System.out.println("查询学生信息:4");
                        System.out.println("想退出学生系统请按:9");
                        Scanner scan1 = new Scanner(System.in);
                        int studentnum = scan1.nextInt();
                        if (studentnum == 1) {
                            System.out.println("请输入新增学生的id,name,sex,age");
                            int id = scan1.nextInt();
                            String name = scan1.next();
                            String sex = scan1.next();
                            int age = scan1.nextInt();
                            mapper.addStudent(id, name, sex, age);
                        } else if (studentnum == 2) {
                            System.out.println("请输入修改学生id,name,sex,age");
                            int id = scan1.nextInt();
                            String name = scan1.next();
                            String sex = scan1.next();
                            int age = scan1.nextInt();
                            mapper.UpdateStudent(id, name, sex, age);
                        } else if (studentnum == 3) {
                            System.out.println("请输入删除学生的id");
                            int id = scan1.nextInt();
                            mapper.deleteStudent(id);
                        } else if (studentnum == 4) {
                            System.out.println("请输入查询学生的id");
                            int id = scan1.nextInt();
                            System.out.println(mapper.selectStudent(id).toString());
                        } else if (studentnum == 9) {
                            System.out.println("已退出学生管理系统");
                            t = false;
                        }
                    }
                } else if (num1 == 2) {
                    boolean t1 = true;
                    while (t1) {
                        System.out.println("新增课程信息:1");
                        System.out.println("修改课程信息:2");
                        System.out.println("删除课程信息:3");
                        System.out.println("查询课程信息:4");
                        System.out.println("想退出课程系统请按:9");
                        Scanner scan2 = new Scanner(System.in);
                        int classnum = scan2.nextInt();
                        if (classnum == 1) {
                            System.out.println("请输入新增课程的classid, classname, classshijian, classxingzhi, xuefen, teacher");
                            String classid = scan2.next();
                            String classname = scan2.next();
                            String classshijian = scan2.next();
                            String classxingzhi = scan.next();
                            String xuefen = scan2.next();
                            String teacher = scan2.next();
                            mapper1.addClass(classid, classname, classshijian, classxingzhi, xuefen, teacher);
                        } else if (classnum == 2) {
                            System.out.println("请输入修改课程classid, classname, classshijian,  classxingzhi, xuefen, teacher");
                            String classid = scan2.next();
                            String classname = scan2.next();
                            String classshijian = scan2.next();
                            String classxingzhi = scan.next();
                            String xuefen = scan2.next();
                            String teacher = scan2.next();
                            mapper1.UpdateClass(classid, classname, classshijian, classxingzhi, xuefen, teacher);
                        } else if (classnum == 3) {
                            System.out.println("请输入删除课程的classid");
                            String id = scan2.next();
                            mapper1.deleteClass(id);
                        } else if (classnum == 4) {
                            System.out.println("请输入查询课程的classid");
                            String id = scan2.next();
                            System.out.println(mapper1.selectClass(id).toString());
                        } else if (classnum == 9) {
                            System.out.println("已退出课程管理系统");
                            t1 = false;
                        }
                    }
                } else if (num1 == 3) {
                    boolean t = true;
                    while (t) {
                        System.out.println("新增学生成绩信息:1");
                        System.out.println("修改学生成绩信息:2");
                        System.out.println("删除学生成绩信息:3");
                        System.out.println("查询学生成绩信息:4");
                        System.out.println("想退出成绩系统请按:9");
                        Scanner scan3 = new Scanner(System.in);
                        int classcjnum = scan3.nextInt();
                        if (classcjnum == 1) {
                            System.out.println("请输入新增学生成绩的studentid,classid,classcj");
                            int studentid = scan3.nextInt();
                            int classid = scan3.nextInt();
                            int classcj = scan3.nextInt();
                            mapper2.Addcj(studentid, classid, classcj);
                        } else if (classcjnum == 2) {
                            System.out.println("请输入修改学生成绩的studentid,classid,classcj");
                            int studentid = scan3.nextInt();
                            int classid = scan3.nextInt();
                            int classcj = scan3.nextInt();
                            mapper2.Updatecj(studentid, classid, classcj);
                        } else if (classcjnum == 3) {
                            System.out.println("请输入删除学生成绩的studentid");
                            int studentid = scan3.nextInt();
                            mapper2.Deletecj(studentid);
                        } else if (classcjnum == 4) {
                            System.out.println("请输入查询学生的studentid");
                            int studentid = scan3.nextInt();
                            System.out.println(mapper2.Selectcj(studentid).toString());
                        } else if (classcjnum == 9) {
                            System.out.println("已退出学生成绩管理系统");
                            t = false;
                        }
                    }
                } else if (num1 == 4) {
                    System.out.println("请输入classid:要查询的课程id");
                    Scanner scan4 = new Scanner(System.in);
                    int classid = scan4.nextInt();
                    List<Integer> list = mapper2.Selectsycj(classid);
                    System.out.println("classid为:" + classid + " 的学生成绩有:");
                    int max = 0;
                    int count = 0;
                    int sum = 0;
                    int[] num = new int[list.size()];
                    for (Integer integer : list) {
                        max = Math.max(integer, max);
                        sum += integer;
                        System.out.println(integer);
                    }
                    for (Integer integer1 : list) {
                        if (integer1 > sum / list.size()) {
                            num[count++] = integer1;
                        }
                    }
                    System.out.println(classid + " 的最高分是:");
                    System.out.println(max);
                    System.out.println(classid + " 的平均分是:");
                    System.out.println(sum / list.size());
                    System.out.println("大于平均数的数有:" + count);
                    for (int i = 0; i < count; i++) {
                        System.out.println(num[i]);
                    }
                    System.out.println("最高分学生信息:");
                    System.out.println(mapper.selectsyStudent(max).toString());
                } else if (num1 == 5) {
                    boolean t = true;
                    while (t) {
                        System.out.println("新增学生成绩信息:1");
                        System.out.println("修改学生成绩信息:2");
                        System.out.println("删除学生成绩信息:3");
                        System.out.println("查询学生成绩信息:4");
                        System.out.println("想退出成绩系统请按:9");
                        Scanner scan4 = new Scanner(System.in);
                        int classcjnum1 = scan4.nextInt();
                        if (classcjnum1 == 1) {
                            System.out.println("请输入新增学生成绩的studentid, math, Chinese,English,py");
                            int studentid = scan4.nextInt();
                            int math = scan4.nextInt();
                            int Chinese = scan4.nextInt();
                            int English =scan4.nextInt();
                            int py=scan4.nextInt();
                            mapper3.AddClasscj2(studentid, math, Chinese,English,py);
                        } else if (classcjnum1 == 2) {
                            System.out.println("请输入修改学生成绩的studentid, math, Chinese,English,py");
                            int studentid = scan4.nextInt();
                            int math = scan4.nextInt();
                            int Chinese = scan4.nextInt();
                            int English =scan4.nextInt();
                            int py=scan4.nextInt();
                            mapper3.UpdateClasscj2(studentid, math, Chinese,English,py);
                        } else if (classcjnum1== 3) {
                            System.out.println("请输入删除学生成绩的studentid");
                            int studentid = scan4.nextInt();
                            mapper3.DeleteClasscj2(studentid);
                        } else if (classcjnum1 == 4) {
                            System.out.println("请输入查询学生的studentid");
                            int studentid = scan4.nextInt();
                            System.out.println(mapper3.SelectClasscj2(studentid).toString());
                        } else if (classcjnum1 == 9) {
                            System.out.println("已退出学生成绩管理系统");
                            t = false;
                        }
                    }
                } else if (num1 == 9) {
                    System.out.println("已退出");
                    n = false;
                }
            }
        }
    }
}
