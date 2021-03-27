package org.csu.mypetstore;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.AccountService;
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
    void testCategory(){
        Category c = catalogService.getCategory("BIRDS");
        System.out.println(c.getCategoryId()+" "+c.getName()+" "+c.getDescription());
        List<Category> a = catalogService.getCategoryList();
        System.out.println(a.get(0).getCategoryId()+" "+a.get(1).getCategoryId()+" ");
    }
    //GET!!

    //对productMapper在catalogService中的两个方法进行测试.
    @Test
    void testProduct(){
        List<Product> pList = catalogService.getProductListByCategory("BIRDS");
        Product p = catalogService.getProduct("AV-CB-01");
        System.out.println(pList.size()+" "+pList.get(0).getProductId());
        System.out.println(p.getName()+" "+ p.getProductId());
    }
    //GET!!

    //测试item接口中定义的三个方法
    @Test
    void testItem(){
        List<Item> iList = catalogService.getItemListByProduct("FI-SW-01");
        Item i0 = iList.get(0);
        System.out.println(iList.size());
        System.out.println(i0.getAttribute1()+" "+i0.getItemId()+" "+i0.getProduct().getName()+" "+i0.getStatus()+" ");
        Item i = catalogService.getItem("EST-1");
        System.out.println(i.getItemId()+" "+i.getProductId()+" "+i.getStatus()+" "+ i.toString());
        System.out.println(catalogService.isItemInStock("EST-1"));
    }

    //测试关键字搜索product的方法是否书写正确
    @Test
    void testSearchProductList(){
        List<Product> sList = catalogService.searchProductList("a");
        System.out.println(sList.size());
    }

    //首先将对象accountService注入
    @Autowired
    AccountService accountService;
    //测试Account的所有方法
    @Test
    void testAccountFunctions(){
        Account account = new Account();
        account.setUsername("lukewarmthee");
        account.setPassword("123");
        account.setEmail("katoby@foxmail.com");
        account.setFirstName("katoby");
        account.setLanguagePreference("chinese");
        account.setFavouriteCategoryId("birds");

//        accountService.insertAccount(account);
//          accountService.updateAccount(account);
        System.out.println(accountService.getAccountByUsernameAndPassword(account).getPassword());

    }//全部成功


}
