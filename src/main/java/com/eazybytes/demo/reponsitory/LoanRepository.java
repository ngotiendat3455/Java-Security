package com.eazybytes.demo.reponsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eazybytes.demo.model.Loans;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {
	List<Loans> findByCustomerIdOrderByCreateDtDesc(int customerId);
}
