package com.eazybytes.demo.reponsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eazybytes.demo.model.Contact;


@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}