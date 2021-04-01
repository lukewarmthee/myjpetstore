package org.csu.mypetstore.persistence;

import org.apache.ibatis.annotations.Param;
import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.domain.Item;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
//这是cartItem对应的接口,包括届时可能会用到的所有方法
//但某个方法超过两个对象是,数据类型就不在xml文件中定义了,在这边写注释吧
public interface CartItemMapper {

    //获取某用户购物车内的商品列表,在进入购物车页面时将会用到这个方法
    List<CartItem> getCartItemList(String username);

    //通过itemId获得所有的在购物车的cartItemList
    List<CartItem> getCartItemListByItemId(String itemId);

    //指定用户名以及特定的商品, 获取该用户对应的数据库中cartItem信息, 可能是用于在加入购物车之时判断是否已经存在于该用户购物车之中
    CartItem getCartItem(@Param("username") String username, @Param("item") Item item);

    //将某件商品加入到某用户的购物车中去,必须要判断用户是否是第一次加,如果是第一次加则修改数据库
    void addCartItem(@Param("username") String username, @Param("item") Item item);

    //将购物车中某个cartItem条目的数量加一
    void cartItemQtyUpOne(@Param("username") String username,@Param("item") Item item);

    //更新用户某商品的总价格,需要的参数有:用户名,商品信息,总价格totalPrice
    void addItemTotalPrice(@Param("username") String username, @Param("item") Item item, @Param("totalPrice") double totalPrice);

    //通过用户名,商品,商品数目等信息修改用户购物车中商品的数目(由用户输入的newQuantity)
    void updateCartItemQuantity(@Param("username") String username,@Param("item") Item item, @Param("newQuantity") int newQuantity);

    //删除某用户的某个商品
    void deleteCartItem(@Param("username") String username, @Param("item") Item item);

    //后台管理时使用,修改某个商品的库存,单价,总价时跟新用户的购物车信息
    void updateCartItem(@Param("itemId") String itemId, @Param("listPrice") BigDecimal listPrice, @Param("inStock") int inStock,
                        @Param("totalPrice") double totalPrice);

    //更新所有用户购物车中某商品的库存
    void updateCartItemStock(@Param("itemId") String itemId,@Param("inStock") int inStock);

    //在后台管理时要下架某个商品,则要将所有的CartItem条目都进行更新,把这些条目都ban掉
    void banCartItem(String itemId);

    //上架购物车中的商品,即将所有包括此商品的cartItem给unban
    void unBanCartItem(String itemId);
}
