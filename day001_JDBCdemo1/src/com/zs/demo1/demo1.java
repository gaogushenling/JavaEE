package com.zs.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*连接数据库*/
public class demo1 {
    public static void main(String[] args) {
        /*1.建立网路连接，即数据库连接*/
        /*连接字符串      用户名      密码*/
        /*jdbc:mysql://[ip地址]:[端口号]/要连接的database名*//*?useUnicode=true&characterEncoding=utf-8!!!!!!!!!!!!!!!!!!!告诉数据库使用useUnicode编码，编码集使用utf-8*/
        Connection conn = null;
        Statement sta = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zsdemo?useUnicode=true&characterEncoding=utf-8","root","root");
            //2.从连接中获取sql语句执行的对象
            sta = conn.createStatement();
            //3.定义一条sql
            String sql = "insert into t1(score) values(60)";
            //4.执行sql语句得到结果
            /*此时的updata不是指的数据库中的update语句，而是指的是能改变数据的语句*/
            /*一个int的返回值代表着影响的行数*/
            int count = sta.executeUpdate(sql);
            //5.处理结果
            if (count > 0){
                System.out.println("数据插入成功");
            }else{
                System.out.println("数据插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
