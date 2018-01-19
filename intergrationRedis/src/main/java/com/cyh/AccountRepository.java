package com.cyh;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by CYH on 2018/1/12.
 */
@Repository
@ClearAuthenticationCache
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Cacheable(value = "commonCache", keyGenerator = "localGenerator")
    Account findByName(String name);

}
