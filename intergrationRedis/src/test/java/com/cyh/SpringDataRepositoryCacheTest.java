package com.cyh;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by CYH on 2018/1/12.
 */
public class SpringDataRepositoryCacheTest {

    @Test
    public void testFindWithCache() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountRepository accountRepository = context.getBean(AccountRepository.class);

        Account account = accountRepository.findByName("cyh01");
        System.out.println("First time: " + account);

        account = accountRepository.findByName("cyh01");
        System.out.println("Second time: " + account);
    }

    @Test
    public void testSaveWithCacheEvict() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountRepository accountRepository = context.getBean(AccountRepository.class);
        accountRepository.save(new Account(2, "cyh02"));
    }


}
