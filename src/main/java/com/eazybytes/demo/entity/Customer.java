package com.eazybytes.demo.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(generator = "uuid2")
	@Column(name = "customer_id")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;

	@Column(name = "email")
	private String email;
//	@Column(name = "pwd")
//	private String pwd;
	@Column(name = "customer_number")
	private String customerNumber;
	@Column(name = "management_number")
	private String managementNumber;
	@Column(name = "organization_name")
	private String organizationName;
//	@Column(name = "staff_name")
//	private String staffName;
	@Column(name = "customer_last_name")
	private String customerLastName;
	@Column(name = "customer_first_name")
	private String customerFirstName;
	@Column(name = "birth_day")
	private String birthDay;
	@Column(name = "gender_code")
	private int genderCode;
	@Column(name = "job_code")
	private String jobCode;
//	year: string,
//	month: string,
//	day: string,
	@Column(name = "phone_number")
	private String phoneNumber;
//	@Column(name = "contact_phone_number")
//	private boolean contactPhoneNumber;
//	phoneNumber: string,
//	contactPhoneNumber: boolean,
	@Column(name = "mail_address")
	private String mailAddress;
	@Column(name = "post_code1")
	private String postCode1;
	@Column(name = "post_code2")
	private String postCode2;
	@Column(name = "prefecture_code")
	private String prefectureCode;
	@Column(name = "address")
	private String address;
	@Column(name = "sendable_dm")
	private boolean sendableDm;

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getManagementNumber() {
		return managementNumber;
	}

	public void setManagementNumber(String managementNumber) {
		this.managementNumber = managementNumber;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

//	public String getStaffName() {
//		return staffName;
//	}
//
//	public void setStaffName(String staffName) {
//		this.staffName = staffName;
//	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public int getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(int genderCode) {
		this.genderCode = genderCode;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

//	public boolean isContactPhoneNumber() {
//		return contactPhoneNumber;
//	}
//
//	public void setContactPhoneNumber(boolean contactPhoneNumber) {
//		this.contactPhoneNumber = contactPhoneNumber;
//	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPostCode1() {
		return postCode1;
	}

	public void setPostCode1(String postCode1) {
		this.postCode1 = postCode1;
	}

	public String getPostCode2() {
		return postCode2;
	}

	public void setPostCode2(String postCode2) {
		this.postCode2 = postCode2;
	}

	public String getPrefectureCode() {
		return prefectureCode;
	}

	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isSendableDm() {
		return sendableDm;
	}

	public void setSendableDm(boolean sendableDm) {
		this.sendableDm = sendableDm;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getPwd() {
//		return pwd;
//	}
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}

}