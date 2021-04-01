package org.csu.mypetstore;

import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CartService;
import org.csu.mypetstore.service.CatalogService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("org.csu.mypetstore.persistence")
class MypetstoreApplicationTests {

    @Autowired
    CatalogService catalogService;

    @Test
    void contextLoads() {
    }

    //对categoryMapper相关的两个方法进行测试
    @Test
    void testCategory() {
        Category c = catalogService.getCategory("BIRDS");
        System.out.println(c.getCategoryId() + " " + c.getName() + " " + c.getDescription());
        List<Category> a = catalogService.getCategoryList();
        System.out.println(a.get(0).getCategoryId() + " " + a.get(1).getCategoryId() + " ");
    }
    //GET!!

    //对productMapper在catalogService中的两个方法进行测试.
    @Test
    void testProduct() {
        List<Product> pList = catalogService.getProductListByCategory("BIRDS");
        Product p = catalogService.getProduct("AV-CB-01");
        System.out.println(pList.size() + " " + pList.get(0).getProductId());
        System.out.println(p.getName() + " " + p.getProductId());
    }
    //GET!!

    //测试item接口中定义的三个方法
    @Test
    void testItem() {
        List<Item> iList = catalogService.getItemListByProduct("FI-SW-01");
        Item i0 = iList.get(0);
        System.out.println(iList.size());
        System.out.println(i0.getAttribute1() + " " + i0.getItemId() + " " + i0.getProduct().getName() + " " + i0.getStatus() + " ");
        Item i = catalogService.getItem("EST-1");
        System.out.println(i.getItemId() + " " + i.getProductId() + " " + i.getStatus() + " " + i.toString());
        System.out.println(catalogService.isItemInStock("EST-1"));
    }

    //测试关键字搜索product的方法是否书写正确
    @Test
    void testSearchProductList() {
        List<Product> sList = catalogService.searchProductList("a");
        System.out.println(sList.size());
    }

    //首先将对象accountService注入
    @Autowired
    AccountService accountService;

    //测试Account的所有方法
    @Test
    void testAccountFunctions() {
        Account account = new Account();
        account.setUsername("lukewarmthee");
        account.setPassword("1");
        account.setEmail("katoby@foxmail.com");
        account.setFirstName("katoby");
        account.setLanguagePreference("chinese");
        account.setFavouriteCategoryId("birds");

//        accountService.insertAccount(account);
//          accountService.updateAccount(account);
        System.out.println(accountService.getAccountByUsernameAndPassword(account).getPassword());

    }//全部成功

    @Autowired
    CartService cartService;    //将要用到的对象自动注入

    //用于测试cartService的所有方法
    @Test
    void testCartServiceFunctions() {
        //商品item0,暂时就先放itemId进来了
        Item item0 = catalogService.getItem("EST-1");
        Item item1 = catalogService.getItem("EST-10");


        //首先测试加入购物车的方法,先加几个嘚,addCartItem()
//        cartService.addCartItem("lukewarmthee", item0);
//        cartService.addCartItem("lukewarmthee", item1);
//          cartService.addCartItem("katoby",item0);

        //验证获取用户数据库中的cartItemList
//        List<CartItem> cartItemList = cartService.getCartItemList("lukewarmthee");
//        System.out.println(cartItemList.size() + " " + cartItemList.get(0).getUsername() + " " + cartItemList.get(0).getItem().getItemId() + " " + cartItemList.get(0).getItem().getAttribute1() + " " + cartItemList.get(0).getItem().getProduct().getName() + " " + cartItemList.get(0).getItem().getProduct().getProductId() + " " + cartItemList.get(0).getQuantity() + " " + cartItemList.get(0).getInStock() + " " + cartItemList.get(0).getListPrice() + " " + cartItemList.get(0).getTotalPrice() + " " + cartItemList.get(0).getBanned() + " ");

        //验证通过itemId获得所有包含该商品的cartItem条目
//        List<CartItem> cartItemList = cartService.getCartItemListByItemId("EST-1");
//        System.out.println(cartItemList.size() + " " + cartItemList.get(1).getUsername() + " " + cartItemList.get(1).getItemId() + " " + cartItemList.get(1).getQuantity() + " " + cartItemList.get(1).getInStock() + " " + cartItemList.get(1).getListPrice() + " " + cartItemList.get(1).getTotalPrice() + " " + cartItemList.get(1).getBanned() + " ");
        //验证通过指定itemId以及username得到相应cartItem
//        CartItem cartItem = cartService.getCartItem("lukewarmthee",item1);
//        System.out.println(cartItem.getUsername() + " " + cartItem.getItemId() + " " + cartItem.getQuantity() + " " + cartItem.getInStock() + " " + cartItem.getListPrice() + " " + cartItem.getTotalPrice() + " " + cartItem.getBanned());
        //验证将某购物车商品条目数量单独加以方法
//        cartService.cartItemQtyUpOne("lukewarmthee",item1);
        //同上,验证修改某购物车条目总价格方法
//        cartService.addItemTotalPrice("lukewarmthee",item1,37);
        //修改某购物车条目商品数目的方法验证
//        cartService.updateCartItemQuantity("lukewarmthee",item1,2);
        //验证删除某个购物车条目的方法
//        cartService.deleteCartItem("lukewarmthee",item0);

        //验证后台修改某商品单价以及库存时使用的方法
//        cartService.updateCartItem("EST-1",item1.getListPrice(),999,11.0);

        //验证后台修改某商品库存方法
//        cartService.updateCartItemStock("EST-1",888);

        //下架某个商品,修改相应的购物车条目
//        cartService.unBanCartItem("EST-1");
    }




}
