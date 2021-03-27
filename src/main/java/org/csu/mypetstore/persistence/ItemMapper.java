package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//千万不要忘记标记
@Repository
public interface ItemMapper {

    //通过从客户端得到的Map<String,Object>参数更新Item库存
    void updateInventoryQuantity(Map<String,Object> param);

    //通过itemId从数据库得到库存量
    int getInventoryQuantity(String itemId);

    //通过productId从数据库返回其对应的List<Item>,用于viewProduct界面
    List<Item> getItemListByProduct(String productId);

    //通过itemId返回具体的Item信息
    Item getItem(String itemId);

}
