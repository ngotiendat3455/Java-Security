package com.eazybytes.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Accounts {
	@Column(name = "customer_id")
	public int customerId;
	
	@Column(name = "account_number")
	public int id;
	
	@Column(name = "account_type")
	public String accountType;
	
	@Column(name = "branch_address")
	public String branchAddress;
	
	@Column(name = "create_dt")
	public String createDt;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	
	
}
