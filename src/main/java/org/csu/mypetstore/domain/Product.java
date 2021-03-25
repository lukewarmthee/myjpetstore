package org.csu.mypetstore.domain;

import java.io.Serializable;

public class Product implements Serializable {
//有时间去查一下执行序列化的作用,在一个项目中
    private static final long serialVersionUID = -7492639752670189553L;

    private String productId;
    private String categoryId;
    private String name;
    private String description;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //返回product.name的toString方法有什么作用吗
    public String toString(){
        return getName();
    }
}
