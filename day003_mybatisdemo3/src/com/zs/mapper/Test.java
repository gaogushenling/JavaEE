package com.zs.mapper;

import com.zs.entity.Emp;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
    public static void main(String[] args) {
        /*创建sqlSession的工厂，一定要告诉它配置文件在哪,工厂一个项目中有一份即可*/
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
                /*Test.class获取类的模板， Test.class.getClassLoader()获取类的加载器，
                * 类加载器获取文件，从src开始，所以好*/
                Test.class.getClassLoader().getResourceAsStream("MyBatis.xml"));
        /*通过工厂生产sqlSession，一切操作数据库都依赖这个session，可以把这个session理解成jdbc中的Connection*/
        SqlSession session = factory.openSession();
        EmpMapper empMapper = session.getMapper(EmpMapper.class);
        for (Emp emp : empMapper.listEmp()) {
            System.out.println(emp);
        }
    }
}
