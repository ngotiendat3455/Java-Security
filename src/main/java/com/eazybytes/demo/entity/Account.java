package com.eazybytes.demo.entity;

import com.eazybytes.demo.entity.role.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "account_id")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID accountId;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "mobile_mail_address")
    private String mobileMailAddress;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "state_type")
    private StaffEnumType stateType;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "administrator_flag")
    private boolean administratorFlag;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @ManyToMany(mappedBy = "accounts", fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileMailAddress() {
        return mobileMailAddress;
    }

    public void setMobileMailAddress(String mobileMailAddress) {
        this.mobileMailAddress = mobileMailAddress;
    }

    public StaffEnumType getStateType() {
        return stateType;
    }

    public void setStateType(StaffEnumType stateType) {
        this.stateType = stateType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdministratorFlag() {
        return administratorFlag;
    }

    public void setAdministratorFlag(boolean administratorFlag) {
        this.administratorFlag = administratorFlag;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public enum StaffEnumType
    {
        WORKING, RETIREMENT, LEAVING
    }
//    private String orgId;
//    private Set<int> combinedStore = new HashSet<>();

// 'emailAddress' |
//         'mobileMailAddress' |
//         // 'orgApplyDate' |
//         'orgId' |
//         'executiveId' |
//         'employmentId' |
//         'stateType' |
//         'saleRoleId' |
//         'customerRoleId' |
//         'masterRoleId' |
//         'staffCode' |
//         'staffId' |
//         'username' |
//         'combinedStore' |
//         'combinedStoreDataList' |
//         'reservationRoleId' |
//         'revenueRoleId' |
//         'inventoryRoleId' |
//         'mailMagazineRoleId' |
//         'commonRoleId' |
//         'administratorFlag' |
//         'password'
}
