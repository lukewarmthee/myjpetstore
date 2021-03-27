package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account") //要进入此功能模块,首先要求url开头为/account
public class AccountController {

    //自动注入accountService
    @Autowired
    AccountService accountService;

    //此乃页面跳转方法,点击链接为/account/viewLogin的方法则返回account下的login.html
    @GetMapping("/viewLogin")
    public String viewLogin(){
        return "account/login";
    }

    //此方法对应logon的post方法
    @PostMapping("/login")
    public String login(Account account, Model model, HttpSession httpSession) {
        //倘若用户名为空
        if (account.getUsername().equals(""))
        {
            String msg = "Please enter your username";
            model.addAttribute("msg",msg);
            return "account/login"; //返回到login页面并且提示输入用户名
        }
        else if (account.getPassword().equals(""))
        {
            String msg = "Please enter your password";
            model.addAttribute("msg",msg);
            return "account/login"; //原理同上
        }
        else
        {
            //查询数据库,是否存在该账户
            account = accountService.getAccountByUsernameAndPassword(account);
            if (account == null)    //若是为空,则返回提示信息用户名或密码不存在
            {
                String msg = "Invalid Username or Password";
                model.addAttribute("msg",msg);
                return "account/login";
            }
            else
                httpSession.setAttribute("account",account);    //没关系,这样就能很好的完成任务,没必要用注解的方式,来让ioc给他注入,矫枉过正了可能
                return "catalog/main";
        }
    }
}
