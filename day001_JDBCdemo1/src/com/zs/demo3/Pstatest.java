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
        String sql = "select * from z_user";
        PreparedStatement psta = conn.prepareStatement(sql);
        ResultSet rs = psta.executeQuery();
        System.out.println(rs.next());
    }

}
