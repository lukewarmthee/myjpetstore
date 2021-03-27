package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/viewMain")
    public String viewMain(){
        return "catalog/main";  //此方法表示,地址栏输入/catalog/view_main过后,返回到catalog包中的main.html页面
    }

    //此处,但地址栏输入/catelog/viewCategory之时,返回到对应的category页面当中去,其中显示该特定category的信息
    @GetMapping("/viewCategory")
    //注意同时还要定义一个生命周期为不知道是啥的Model对象,//创建model对象,要给客户端传值则使用一个Model对象,这是之前的注释
    public String viewCategory(String categoryId, Model model){
        if(categoryId != null){
            Category category = catalogService.getCategory(categoryId); //因为届时要在category.html中显示category.name
            List<Product> productList = catalogService.getProductListByCategory(categoryId);
            model.addAttribute("category",category);
            model.addAttribute("productList",productList);
            return "catalog/category";  //返回在catalog目录中的名为category的显示文件,并且使用thymeleaf进行渲染
        }
        return "catalog/main";  //若是传入的categoryId的值为空,则并不进行页面跳转
    }

    @GetMapping("/viewProduct")
    public String viewProduct(String productId, Model model) {
        if (productId != null) {
            Product product = catalogService.getProduct(productId);
            List<Item> itemList = catalogService.getItemListByProduct(productId);
            model.addAttribute("product",product);
            model.addAttribute("itemList",itemList);
        }
        return "catalog/product";
    }
}
