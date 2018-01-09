package cacheOfAnno;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public class AccountService {

    // 使用了一个缓存名叫 accountCache
    @Cacheable(value = "accountCache", condition = "#userName.length() <= 4")
    public Account getAccountByName(String userName) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(userName);
    }

    private Account getFromDB(String acctName) {
        System.out.println("real querying db..." + acctName);
        return new Account(acctName);
    }

    // 清空 accountCache 缓存
    @CacheEvict(value = "accountCache", key = "#account.getName()")
    public void updateAccount(Account account) {
        updateDB(account);
    }

    private void updateDB(Account account) {
        System.out.println("real update db..." + account.getName());
    }

    @CachePut(value = "accountCache", key = "#account.getName()")
    public Account updateAccount2(Account account) {
        return updateDB2(account);
    }

    private Account updateDB2(Account account) {
        System.out.println("real updating db 2..." + account.getName());
        return account;
    }

    // 清空 accountCache 缓存
    @CacheEvict(value = "accountCache", allEntries = true)
    public void reload() {}

    @Cacheable(value = "accountCache", key = "#userName.concat(#password)")
    public Account getAccount(String userName, String password, boolean sendLog) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(userName, password);
    }

    private Account getFromDB(String userName, String password) {
        return null;
    }

}
