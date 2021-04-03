package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.service.CartService;
import org.csu.mypetstore.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {

    //首先注入需要用到的Service层对象
    @Autowired
    CartService cartService;
    @Autowired
    CatalogService catalogService;

    //为点击购物车图标浏览购物车添加页面跳转方法
    @GetMapping("/viewCart")
    String viewCart(String username, Model model) {

        List<CartItem> cartItemList = cartService.getCartItemList(username);

        //判断得到的cartItemList是否不为空
        if (cartItemList.size() > 0) {
            //返回一个cartMessage,提示购物车不为空
            String cartMessage = "cartNotEmpty";
            model.addAttribute("cartMessage", cartMessage);
            model.addAttribute("cartItemList", cartItemList);
        } else {
            //否则返回为空
            String cartMessage = "cartEmpty";
            model.addAttribute("cartMessage", cartMessage);
        }
        return "cart/cart"; //返回cart目录下的cart.html
    }

    //添加到购物车的Controller方法
    @GetMapping("addItemToCart")
    public String addItemToCart(String username, String itemId, Model model) {
        //通过itemId得到对应的item
        Item item = catalogService.getItem(itemId);
        //首先将该商品加入购物车(假设该item不在购物车中),此时商品数量暂时设为0
        cartService.addCartItem(username, item);
        //将数量加一,不管item在不在购物车中都要加一
        cartService.cartItemQtyUpOne(username, item);
        //得到此时的cartItem条目,主要是需要quantity
        CartItem cartItem = cartService.getCartItem(username, item);
        //得到此商品的单价
        BigDecimal listPrice = item.getListPrice();
        //将商品数量设为BigDecimal类型
        BigDecimal quantity = new BigDecimal(cartItem.getQuantity());
        //得到此商品总价,首先采用multiply()方法将BigDecimal类型的单价设为倍数,然后改为double类型
        double totalPrice = quantity.multiply(listPrice).doubleValue();
        //将totalPrice进行修改
        cartService.addItemTotalPrice(username, item, totalPrice);
        //得到此用户的cartItemList
        List<CartItem> cartItemList = cartService.getCartItemList(username);
        //返回购物车不为空的消息
        String cartMessage = "cartNotEmpty";
        model.addAttribute("cartMessage", cartMessage);
        model.addAttribute("cartItemList", cartItemList);
        return "cart/cart"; //返回cart目录下的cart.html
    }

    //移除购物车商品的控制器方法
    @GetMapping("/removeCartItem")
    String removeCartItem(String username, String itemId, Model model) {

        //将特定商品从购物车表中删除
        Item item = catalogService.getItem(itemId);
        cartService.deleteCartItem(username, item);

        //得到cartItem列表
        List<CartItem> cartItemList = cartService.getCartItemList(username);

        //判断得到的cartItemList是否不为空
        if (cartItemList.size() > 0) {
            //返回一个cartMessage,提示购物车不为空
            String cartMessage = "cartNotEmpty";
            model.addAttribute("cartMessage", cartMessage);
            model.addAttribute("cartItemList", cartItemList);
        } else {
            //否则返回为空
            String cartMessage = "cartEmpty";
            model.addAttribute("cartMessage", cartMessage);
        }
        return "cart/cart"; //返回cart目录下的cart.html

    }

}
