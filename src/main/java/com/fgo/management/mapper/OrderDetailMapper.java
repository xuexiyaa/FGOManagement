package com.fgo.management.mapper;

import com.fgo.management.dto.OrderStatusInfo;
import com.fgo.management.dto.QueryOrderCondition;
import com.fgo.management.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDetailMapper {

    void insert(@Param("order") OrderDetail orderDetail);

    void update(@Param("order") OrderDetail orderDetail);

    List<OrderDetail> queryOrderDetails(@Param("condition") QueryOrderCondition condition);

    void updateOrderStatus(@Param("statusInfo") OrderStatusInfo orderStatusInfo);

    OrderDetail queryByOrderId(@Param("orderId") int orderId);

    List<OrderDetail> queryByPlayerAccountWithLock(@Param("account") String playerAccount);
}