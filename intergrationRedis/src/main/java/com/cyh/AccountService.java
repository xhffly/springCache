package com.cyh;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/11.
 */
@Service
public class AccountService {


    @Cacheable(value = "commonCache")
    public Account getAccountByName(String userName) {
        System.out.println("real query account..." + userName);
        return getFromDB(userName);
    }

    private Account getFromDB(String acctName) {
        System.out.println("real querying db..." + acctName);
        Account account = new Account();
        account.setName(acctName);
        account.setId(1);
        return account;
    }

    /**
     * @CacheEvict 注释来标记要清空缓存的方法，当这个方法被调用后，即会清空缓存。再次查询时将从从代码逻辑从数据库获取数据
     * @param account
     */
    @CacheEvict(value = "commonCache", key = "#account.getName()")
    public void updateAccount1(Account account) {
        updateDB(account);
    }

    private Account updateDB(Account account) {
        System.out.println("Update account to DB. " + account);
        return account;
    }

    /**
     * @CachePut 注释，这个注释可以确保方法被执行，同时方法的返回值也被记录到缓存中，实现缓存与数据库的同步更新
     * @param account
     * @return
     */
    @CachePut(value = "commonCache", key = "#account.getName()")
    public Account updateAccount(Account account) {
        return updateDB(account);
    }

}
