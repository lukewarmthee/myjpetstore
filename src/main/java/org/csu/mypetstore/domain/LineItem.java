package org.csu.mypetstore.domain;

import java.math.BigDecimal;

public class LineItem {
    private String username;    //此订单商品对应用户id
    private String orderId;     //对应订单编号
    private String itemId;      //此商品编号
    private int quantity;       //用户购买的商品数量
    private BigDecimal listPrice;   //该商品单价
    private double totalPrice;  //此商品的总价

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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
