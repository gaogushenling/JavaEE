package com.zs.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Statement有一个致命的bug叫sql注入
 * 请输入密码：
 * asd' or '1' = '1
 * select * from z_user where user = 'qwe' and passwork = 'asd' or '1' = '1'
 *
 * true
 */
//所以以后一律使用
    /*PreparedStatement预编译的sql语句执行载体
	优点：防止sql注入
		设置参数非常方便
    * */
public class StatementBUG {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = input.nextLine();
        System.out.println("请输入密码：");
        String passwork = input.nextLine();

        String sql = "select * from z_user where user = '" + username +"' and passwork = '" + passwork +"'";
        System.out.println(sql);
        Connection conn = null;
        Statement sta = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zsdemo?useUnicode=true&characterEncoding=utf-8",
                    "root","root");
            sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            System.out.println(rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
