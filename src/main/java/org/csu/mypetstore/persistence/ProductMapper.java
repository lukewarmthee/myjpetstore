package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

//ioc创建对象
@Repository
public interface ProductMapper {

    //viewMain界面通过点击某个大类转到该大类的所有产品Product的信息，需要用到这个方法
    List<Product> getProductListByCategory(String categoryId);

    //暂时不要用到，这个方法的作用在于通过productId返回相应的具体Product信息
    Product getProduct(String productId);
}
