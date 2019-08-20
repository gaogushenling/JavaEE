package com.zs.test;

import com.zs.entity.OrderDetail;
import com.zs.mapper.OrderDetailMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class OrderDetailMapperTest {
    public static void main(String[] args) {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
                OrderDetailMapperTest.class.getClassLoader().getResourceAsStream("mybatis.xml")
        );
        SqlSession session = factory.openSession(true);/*true 设置自动提交！！！！！！！！！*/

        //根据id查询所有详情
        OrderDetailMapper orderDetailMapper = session.getMapper(OrderDetailMapper.class);
        for (OrderDetail orderDetail : orderDetailMapper.listDetailByOrderId("22")) {
            System.out.println(orderDetail);
        }
        //根据订单id删除详情
       /* System.out.println(orderDetailMapper.deleteDetail("11"));*/

        //根据订单id和详情id修改
//        OrderDetail orderDetail = new OrderDetail();
//        orderDetail.setDetailId("22");
//        orderDetail.setOrderId("22");
//        orderDetail.setGoodsId(33);
//        orderDetailMapper.updateDetailBygoodsId(orderDetail);

       //增加订单详情

    }
}
