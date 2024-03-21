package com.eazybytes.demo.reponsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eazybytes.demo.model.Cards;
import com.eazybytes.demo.model.Customer;

public interface CardsRepository extends CrudRepository<Cards, Long>{
	List<Cards> findByCustomerId(int customerId);
}
