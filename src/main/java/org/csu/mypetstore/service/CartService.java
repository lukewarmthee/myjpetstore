package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.persistence.CartItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
//与购物车相关的业务层
public class CartService {

    //自动注入DAO层接口
    @Autowired
    CartItemMapper  cartItemMapper;

    //获得某用户的所有购物车商品
    public List<CartItem> getCartItemList(String username){
        return cartItemMapper.getCartItemList(username);
    }

    //通过itemId获得所有加入了该商品的cartItem条目
    public List<CartItem> getCartItemListByItemId(String itemId){
        return cartItemMapper.getCartItemListByItemId(itemId);
    }

    //通过username以及itemId获得指定的cartItem
    public CartItem getCartItem(String username,Item item){
        return cartItemMapper.getCartItem(username,item);
    }

    //用户点击add to cart是,若是该商品未加入购物车,则加入数据库
    public void addCartItem(String username, Item item){
        cartItemMapper.addCartItem(username,item);
    }

    //将购物车中某个cartItem条目的数量加一
    public void cartItemQtyUpOne(String username,Item item){
        cartItemMapper.cartItemQtyUpOne(username, item);
    }

    //更新用户某商品的总价格,需要的参数有:用户名,商品信息,总价格totalPrice
    public void addItemTotalPrice(String username, Item item, double totalPrice){
        cartItemMapper.addItemTotalPrice(username, item, totalPrice);
    }

    //通过用户名,商品,商品数目等信息修改用户购物车中商品的数目(由用户输入的newQuantity)
    public void updateCartItemQuantity(String username, Item item, int newQuantity){
        cartItemMapper.updateCartItemQuantity(username,item,newQuantity);
    }

    //删除某用户的某个商品
    public void deleteCartItem( String username, Item item){
        cartItemMapper.deleteCartItem(username,item);
    }

    //后台管理时使用,修改某个商品的库存,单价,总价时跟新用户的购物车信息
    public void updateCartItem(String itemId, BigDecimal listPrice, int inStock, double totalPrice){
        cartItemMapper.updateCartItem(itemId,listPrice,inStock,totalPrice);
    }

    //更新所有用户购物车中某商品的库存
    public void updateCartItemStock(String itemId, int inStock){
        cartItemMapper.updateCartItemStock(itemId,inStock);
    }

    //在后台管理时要下架某个商品,则要将所有的CartItem条目都进行更新,把这些条目都ban掉
    public void banCartItem(String itemId){
        cartItemMapper.banCartItem(itemId);
    }

    //上架购物车中的商品,即将所有包括此商品的cartItem给unban
    public void unBanCartItem(String itemId){
        cartItemMapper.unBanCartItem(itemId);
    }

}
