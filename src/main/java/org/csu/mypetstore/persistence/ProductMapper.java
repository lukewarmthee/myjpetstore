package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

//ioc创建对象
@Repository
public interface ProductMapper {

    //viewMain界面通过点击某个大类转到该大类的所有产品Product的信息，需要用到这个方法
    List<Product> getProductListByCategory(String categoryId);

    //用于通过productId返回对应的product的场景
    Product getProduct(String productId);

    //通过搜索框中的关键字keywords返回对应的productList,用于搜索product场景
    List<Product> searchProductList(String keywords);
}
