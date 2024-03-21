package com.eazybytes.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AccountTransactions {

	@Id
	@Column(name = "transaction_id")
	public String id;
	
	@Column(name = "account_number")
	public int accountNumber;
	@Column(name = "transaction_dt")
	public String transactionDt;
	@Column(name = "transaction_summary")
	public String transactionSummary;
	@Column(name = "transaction_type")
	public String transactionType;
	@Column(name = "transaction_amt")
	public int transactionAmt;
	@Column(name = "closing_balance")
	public int closingBalance;
	@Column(name = "create_dt")
	public String createDt;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTransactionDt() {
		return transactionDt;
	}
	public void setTransactionDt(String transactionDt) {
		this.transactionDt = transactionDt;
	}
	public String getTransactionSummary() {
		return transactionSummary;
	}
	public void setTransactionSummary(String transactionSummary) {
		this.transactionSummary = transactionSummary;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getTransactionAmt() {
		return transactionAmt;
	}
	public void setTransactionAmt(int transactionAmt) {
		this.transactionAmt = transactionAmt;
	}
	public int getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(int closingBalance) {
		this.closingBalance = closingBalance;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
}
