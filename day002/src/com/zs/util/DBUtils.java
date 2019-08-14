package com.zs.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    /**
     * 万能查询数据库
     * @param c
     * @param <T>
     * @return
     */
   public static <T> List<T> queryAll(Class c){
       //获取表名
       /*
       反射类上的注解
       如果 有  用注解属性值
       没有 用  类名
       * */
       Table table = (Table) c.getDeclaredAnnotation(Table.class);
       String className = "";
       if (table == null) {
           className = c.getSimpleName();
       }else {
           className = table.name();
       }
       //利用反射出的名字，生成sql语句。
       String sql = "select * from " + className;
//       System.out.println(sql);

       //JDBC相关，建立连接
       Connection conn = null;
       PreparedStatement psta = null;
       ResultSet rs = null;

       List<T> list = new ArrayList<>();

       try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zsdemo?useUnicode=true&characterEncoding=utf-8&useSSl=false",
                   "root","root");
           psta = conn.prepareStatement(sql);
           rs = psta.executeQuery();
           while(rs.next()){
               Field[] fields = c.getDeclaredFields();
               //创建一个对象
               //通过无参构造器创建对象
               T t = (T) c.newInstance();
               for (Field field: fields) {
                   //强制开权限
                   field.setAccessible(true);
                   //获取注解里的信息，信息代表数据库的列名
                   Column column = field.getDeclaredAnnotation(Column.class);
                   String fieldName = "";
                   //如果没有注解，使用属性名
                   if (column == null){
                       fieldName = field.getName();
                   }else{
                       //使用注解的属性
                       fieldName = column.name();
                   }
                   //t对象设置值
                   field.set(t,rs.getObject(fieldName));
               }
               //将对象添加到集合中
               list.add(t);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (InstantiationException e) {
           e.printStackTrace();
       } finally{
           if (conn != null){
               try {
                   conn.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if (psta != null){
               try {
                   psta.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if (rs != null){
               try {
                   rs.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
       }



       return list;

    }
}
