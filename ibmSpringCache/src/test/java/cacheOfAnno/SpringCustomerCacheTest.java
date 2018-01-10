package cacheOfAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/1/10.
 */
public class SpringCustomerCacheTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-customer-cache-anno.xml");

        AccountService s = (AccountService) context.getBean("accountServiceBean");

        Account account = s.getAccountByName("cyh");
        System.out.println("passwd=" + account.getPassword());
        account = s.getAccountByName("cyh");
        System.out.println("passwd=" + account.getPassword());
    }

}
