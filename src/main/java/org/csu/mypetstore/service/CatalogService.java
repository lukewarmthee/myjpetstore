package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.CategoryMapper;
import org.csu.mypetstore.persistence.ItemMapper;
import org.csu.mypetstore.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ItemMapper itemMapper;

    //实现category领域中所定义的两个方法对应的控制器功能
    public List<Category> getCategoryList(){
        return categoryMapper.getCategoryList();
    }

    public Category getCategory(String categoryId){
        return categoryMapper.getCategory(categoryId);
    }

    //实现product领域所定义的两个方法
    //1.通过productId返回product
    public Product getProduct(String productId) {
        return productMapper.getProduct(productId);
    }

    //2.通过categoryId返回其对应的所有产品product的信息
    public List<Product> getProductListByCategory(String categoryId) {
        return productMapper.getProductListByCategory(categoryId);
    }

    //这里建立与ItemMapper接口定义的三个方法的连接,实现三个对应的服务
    //1.得到ListItem, 用于viewProduct页面
    public List<Item> getItemListByProduct(String productId) {
        return itemMapper.getItemListByProduct(productId);
    }

    //2.通过itemId得到对应Item详情,这里用于viewItem页面
    public Item getItem(String itemId) {
        return itemMapper.getItem(itemId);
    }

    //3.通过itemId返回该item是否还有库存
    public boolean isItemInStock(String itemId) {
        return itemMapper.getInventoryQuantity(itemId) > 0;
    }

}
