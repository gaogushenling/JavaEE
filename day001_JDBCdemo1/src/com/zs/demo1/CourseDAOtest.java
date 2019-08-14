package com.zs.demo1;

import com.zs.dao2.CourseDAO;
import com.zs.dao2.impl.CourseDAOimpl;

import java.util.List;

/**
 * DAO模式
 *  * Database Access Object
 *  * dao下所有的类只有一个职责操作数据库,这里面不涉及任何业务
 *  * 一个DAO类只操作一张表
 * */
public class CourseDAOtest {
    public static void main(String[] args) {
        CourseDAO courseDAO = new CourseDAOimpl();
       /* int row = courseDAO.deleteCourseByCno("c008");
        System.out.println(row);*/

      /* Course course = new Course();
       course.setCon("c008");
       course.setCname("来跨服呢");
       course.setCredit(4);
       course.setSemester(5);
//       courseDAO.saveCourse(course);
        courseDAO.updateCourseByCno(course);*/
      List<Course> courseList = courseDAO.listCourse();
         for (Course course:courseList) {
            System.out.println(course);
        }
    }
}
