package com.zs.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库查询的构思
 * orm
 * 对象          关系           映射
 * Object Relational Mapping
 */
public class SelectTest2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement sta = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zsdemo?useUnicode=true&characterEncoding=utf-8",
                    "root","root");
            sta = conn.createStatement();
            String sql = "select * from course";
            ResultSet rs = sta.executeQuery(sql);
            List<Course> courseList = new ArrayList<>();
            while (rs.next()){
                /*System.out.println(rs.getString("Cno"));
                System.out.println(rs.getString("Cname"));
                System.out.println(rs.getInt("Credit"));
                System.out.println(rs.getInt("Semester"));*/
                //将数据库里的一条数据映射成一个java对象
                Course c = new Course();
                c.setCon(rs.getString("Cno"));
                c.setCname(rs.getString("Cname"));
                c.setCredit(rs.getInt("Credit"));
                c.setSemester(rs.getInt("Semester"));
//                System.out.println(c);
//                将这个对象存入到集合中
                courseList.add(c);
            }
            for (Course course:courseList) {
                System.out.println(course);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
