package com.eazybytes.demo.reponsitory;

import com.eazybytes.demo.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountReponsitory extends CrudRepository<Account, Long> {
    List<Account> findByUsername(String username);
}
