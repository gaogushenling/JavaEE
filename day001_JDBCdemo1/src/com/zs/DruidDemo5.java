package com.zs;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*德鲁伊的使用*/
public class DruidDemo5 {
    public static void main(String[] args) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/zsdemo?useUnicode=true&characterEncoding=utf-8");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");


        try {
            //getConnection()返回的不是DriverManager。getConnection获得连接对象，是包装了DriverManager。getConnection的对象
            Connection conn = druidDataSource.getConnection();
            PreparedStatement psta = conn.prepareStatement("select * from z_user");
            ResultSet rs = psta.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("passwork"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
