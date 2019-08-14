package com.zs.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pstatest {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zsdemo?useUnicode=true&characterEncoding=utf-8",
                "root","root");
//        String sql = "select * from z_user";
        String sql = "select * from t1 where id = ? and score = ? ";
        PreparedStatement psta = conn.prepareStatement(sql);
        /*执行sql之前给所有？设置值*/
        /*第一个参数设置的是那个问号，从1开始*/
        psta.setString(1,"1");
        psta.setString(2,"60");
        ResultSet rs = psta.executeQuery();
        System.out.println(rs.next());
    }

}
