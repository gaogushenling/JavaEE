package com.zs.mapper;

import com.zs.entity.OrderDetail;

import java.util.List;

public interface OrderDetailMapper {

    List<OrderDetail> listDetailByOrderId(String orderId);

    int deleteDetail(String orderId);

    int updateDetailBygoodsId(OrderDetail orderDetail);

    int addDetail(OrderDetail orderDetail);


}
