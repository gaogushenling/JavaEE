package com.zs.test;

import com.zs.entity.Order;
import com.zs.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.Random;
import java.util.UUID;

public class OrderMapperTest {
    public static void main(String[] args) {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
                OrderMapperTest.class.getClassLoader().getResourceAsStream("mybatis.xml")
        );
        SqlSession session = factory.openSession(true);/*true 设置自动提交！！！！！！！！！*/

        //生成接口代理  //查询所有订单
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
      /*  for (Order order : orderMapper.listOrder()) {
            System.out.println(order);
        }*/

       //根据订单ID和用户ID修改订单
      /* Order order = new Order();
       order.setOrderId("11");
       order.setMemberId(11);
       order.setStatus(88);

        System.out.println(orderMapper.updateOrderByMemberId(order));*/

      //根据用户ID查询订单
       /* System.out.println(orderMapper.listOrderID("11"));*/

        //增加订单                   //时间为null！？？？？？？？？？？？？？？？？？？？？？
       /* Order order = new Order();
                   //随机生成订单号！！！！！！！
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        int randomInt = new Random().nextInt(899999) + 100000;
        String orderId = uuid + randomInt;
        order.setOrderId(orderId);
        order.setStatus(77);
        order.setMemberId(77);
        System.out.println(orderMapper.addOrder(order));*/

        //根据订单id删除订单
       /* System.out.println(orderMapper.deleteOrder("77"));*/
        //根据用户id删除订单
        /*orderMapper.deleteOrdermemberId(11);*/

    }
}
