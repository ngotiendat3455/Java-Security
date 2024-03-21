package com.eazybytes.demo.reponsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eazybytes.demo.model.Customer;

@Repository
public interface CustomerReponsitory extends CrudRepository<Customer, Long> {
	List<Customer> findByEmail(String email);
}
