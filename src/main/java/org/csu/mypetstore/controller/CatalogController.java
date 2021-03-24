package org.csu.mypetstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @GetMapping("/view_main")
    public String view(){
        return "catalog/main";  //此方法表示,地址栏输入/catalog/view_main过后,返回到catalog包中的main.html页面
    }
}
