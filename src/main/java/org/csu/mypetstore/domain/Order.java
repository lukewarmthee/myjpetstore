package org.csu.mypetstore.domain;

import java.util.List;

public class Order {
    private String username;    //订单对应用户
    private String orderId;     //订单编号,作为主键
    private String name;        //订单的用户昵称
    private String address;     //订单配送地址
    private String phone;       //收件人电话
    private double cost;        //订单总消费
    private List<LineItem> lineItemList;  //每一个订单对应做个配送商品
    private int dispatched;     //订单是否已发货

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<LineItem> getLineItemList() {
        return lineItemList;
    }

    public void setLineItemList(List<LineItem> lineItemList) {
        this.lineItemList = lineItemList;
    }

    public int getDispatched() {
        return dispatched;
    }

    public void setDispatched(int dispatched) {
        this.dispatched = dispatched;
    }
}
