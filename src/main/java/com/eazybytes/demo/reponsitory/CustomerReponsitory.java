package com.eazybytes.demo.reponsitory;

import com.eazybytes.demo.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CustomerReponsitory extends CrudRepository<Customer, Long> {
	List<Customer> findByEmail(String email);
}