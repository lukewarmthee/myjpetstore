package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {

    List<Category> getCategoryList();   //此方法用于得到所有大类的List

    Category getCategory(String categoryId);    //通过输入categoryId从数据库中返回该大类的所有信息
}
