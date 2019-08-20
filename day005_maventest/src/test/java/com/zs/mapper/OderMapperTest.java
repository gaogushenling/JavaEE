package com.zs.mapper;

import com.zs.entity.Order;
import com.zs.test.OrderDetailMapperTest;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class OderMapperTest {
    @Test
    public void listOrderTest(){
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
                OrderDetailMapperTest.class.getClassLoader().getResourceAsStream("mybatis.xml")
        );
        SqlSession session = factory.openSession(true);/*true 设置自动提交！！！！！！！！！*/
        //生成代理接口
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        for (Order order : orderMapper.listOrder()) {
            System.out.println(order);
        }
    }
    @Test
    public void deleteOrderTest(){
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
                OrderDetailMapperTest.class.getClassLoader().getResourceAsStream("mybatis.xml")
        );
        SqlSession session = factory.openSession(true);/*true 设置自动提交！！！！！！！！！*/
        //生成代理接口
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        System.out.println(orderMapper.deleteOrder("11"));

    }
}
