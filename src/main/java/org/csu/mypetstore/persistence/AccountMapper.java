package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {

    //直接通过用户名获得Account, 用于输入用户名之时直接在下方判断用户是否存在以进行提示
    Account getAccountByUsername(String username);

    //通过用户名和密码共同判断用户是否存在
    Account getAccountByUsernameAndPassword(Account account);

    //在用户注册时将用户信息插入Account表中,部分信息
    void insertAccount(Account account);

    //在用户注册时将用户信息插入Profile表中去,部分信息,即最后几个相当于现代的大数据用户画像,那些信息,喜欢什么,要不要横幅广告,什么语言之类的
    void insertProfile(Account account);

    //同上,还有Signon表
    void insertSignon(Account account);

    //修改Account表,修改用户信息时
    void updateAccount(Account account);

    //同上
    void updateProfile(Account account);

    //更新signon表
    void updateSignon(Account account);

}
