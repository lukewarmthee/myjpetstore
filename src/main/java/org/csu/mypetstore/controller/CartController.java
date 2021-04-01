package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.service.CartService;
import org.csu.mypetstore.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
