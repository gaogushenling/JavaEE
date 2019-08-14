package com.zs.dao2.impl;

import com.zs.dao2.CourseDAO;
import com.zs.demo1.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOimpl implements CourseDAO {
    @Override
    public int deleteCourseByCno(String cno) {
        Connection conn = null;
        Statement sta = null;
        int row = 0;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zsdemo?useUnicode=true&characterEncoding=utf-8",
                    "root", "root");
            sta = conn.createStatement();
            String sql = "delete from course where cno = '" + cno + "'";
            row = sta.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (sta != null) {
                    sta.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return row;
    }

    @Override
    public int saveCourse(Course course) {
        Connection conn = null;
        Statement sta = null;
        int row = 0;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zsdemo?useUnicode=true&characterEncoding=utf-8",
                    "root", "root");
            sta = conn.createStatement();
            String sql = "insert into course values('"+course.getCon()+"','"+
                    course.getCname()+"',"+ course.getCredit()+","+ course.getSemester()+")";
//            System.out.println(sql);
            row = sta.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (sta != null) {
                    sta.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return row;
    }

    @Override
    public int updateCourseByCno(Course course) {
        Connection conn = null;
        Statement sta = null;
        int row = 0;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zsdemo?useUnicode=true&characterEncoding=utf-8",
                    "root", "root");
            sta = conn.createStatement();
            String sql = "update course set cname = '" + course.getCname() + "',credit = " + course.getCredit() +
                    ",semester = " + course.getSemester() + " where cno = '" + course.getCon() + "'";
//            System.out.println(sql);
            row = sta.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (sta != null) {
                    sta.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return row;
    }

    @Override
    public List<Course> listCourse() {
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        List<Course> courseList = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zsdemo?useUnicode=true&characterEncoding=utf-8",
                    "root", "root");
            sta = conn.createStatement();
            String sql = "select * from course";
//            System.out.println(sql);
            rs = sta.executeQuery(sql);
           while (rs.next()){
               Course course = new Course();
               course.setCon(rs.getString("Cno"));
               course.setCname(rs.getString("Cname"));
               course.setCredit(rs.getInt("Credit"));
               course.setSemester(rs.getInt("Semester"));
               courseList.add(course);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (sta != null) {
                    sta.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return courseList;
    }
}
