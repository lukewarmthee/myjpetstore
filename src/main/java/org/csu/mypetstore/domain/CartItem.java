package org.csu.mypetstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {

    private static final long serialVersionUID = 6620528781626504362L;

    //此domain对象表示购物车中的某个item,与数据库中的cartItem表对应,包括的六个购物车某件商品必须的属性如下
    private String username;    //定义这个商品是位于哪个用户的购物车,故而username是主键

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    private Item item;  //商品对应的ID
    private int quantity;   //该商品位于购物车中的数量
    private int inStock;    //这可能是指该商品所有的库存量
    private BigDecimal listPrice;   //这是item的属性,即其单品售价
    private double totalPrice;  //购物车中该商品的总价
    private int banned;

    public int getBanned() {
        return banned;
    }

    public void setBanned(int banned) {
        this.banned = banned;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
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
