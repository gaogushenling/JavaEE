package com.zs.dao2;

import com.zs.demo1.Course;

import java.util.List;

public interface CourseDAO {
    /**
     * 根据Course的主键cno删除一条数据
     * @param cno
     * @return
     */
    int deleteCourseByCno(String cno);

    /**
     * 增加
     */
    int saveCourse(Course course);

    /**
     * 修改
     */
    int updateCourseByCno(Course course);

    /**
     * 查询
     */
    List<Course> listCourse();
}
