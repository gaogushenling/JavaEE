package com.zs.mapper;

import com.zs.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    List<Course> listCourse();
    /*使用注解强制命名*/
    int saveCourse(@Param("cno") String cno, @Param("cname") String cname,@Param("credit") int credit,@Param("semester") int semester);
}
