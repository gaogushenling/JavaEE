package com.zs.demo4;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        MyDataSource myDataSource = new MyDataSource("jdbc:mysql://localhost:3306/zsdemo?useUnicode=true&characterEncoding=utf-8",
                "root","root");
        Connection conn = myDataSource.getConnection();
//        conn.close();/*配合MyConnection类*/
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
