package com.cyh;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/1/11.
 */
public class SpringCacheTest {


    @Test
    public void testGetFromCache() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
        AccountService service = context.getBean(AccountService.class);
        service.getAccountByName("cyhbyw");
        service.getAccountByName("cyhbyw");
    }

    @Test
    public void testUpdateWithCacheEvict() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
        AccountService service = context.getBean(AccountService.class);
        Account account = service.getAccountByName("cyh");
        service.updateAccount1(account);
        service.getAccountByName("cyh");
    }

    @Test
    public void testUpdateWithCachePut() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
        AccountService service = context.getBean(AccountService.class);
        Account account = service.getAccountByName("cyh");
        System.out.println("First time account: " + account);

        account = new Account(222, "cyh");
        service.updateAccount(account);

        account = service.getAccountByName("cyh");
        System.out.println("Second time account: " + account);
    }


}
