package org.csu.mypetstore.persistence;

import org.apache.ibatis.annotations.Param;
import org.csu.mypetstore.domain.LineItem;
import org.csu.mypetstore.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//自动注入接口对象
public interface LineItemMapper {

    //获取所有订单,用于后台订单管理
    List<Order> getOrders();

    //获取某用户的所有订单,用于用户查看所有订单
    List<Order> getOrderListByUsername(String username);

    //获取某用户某订单的所有商品,需要两个变量,订单编号以及用户名)同样用于用户查看所有订单,点击My Order
    List<LineItem> getLineItemList(@Param("orderId") String orderId, @Param("username") String username);

    //新建订单,用于用户确认订单,插入数据库
    void insertOrder(Order order);

    //用户确定订单时将其中商品信息插入lineItem表中
    void insertLineItem(LineItem lineItem);

    //发货,即修改order表中的dispatched属性,将其修改为1,表示已发货,这里需要username以及orderId两个参数
    void deliverOrder(@Param("orderId") String orderId, @Param("username") String username);


}
