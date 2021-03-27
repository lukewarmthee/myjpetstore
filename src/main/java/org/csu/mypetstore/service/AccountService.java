package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public Account getAccount(String username) {
        return accountMapper.getAccountByUsername(username);
    }

    //java可以函数重用,当然你爱打字别人也拦不倒你, 这里直接用account作为参数, 因为不管是登录注册改密码还是什么传入的都是一个Account对象
    public Account getAccountByUsernameAndPassword(Account account) {
        return accountMapper.getAccountByUsernameAndPassword(account);
    }

    //因为这三个account方法往往同时进行,所以合在一块儿对吗,那这个标记又是什么意思,transactional是事物缓存的意思
    // @Transactional 是声明式事务管理 编程中使用的注解
    @Transactional
    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
        accountMapper.insertProfile(account);
        accountMapper.insertSignon(account);
    }

    @Transactional
    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
        accountMapper.updateProfile(account);
        accountMapper.updateSignon(account);
    }

}
