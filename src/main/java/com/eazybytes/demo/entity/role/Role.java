package com.eazybytes.demo.entity.role;

import com.eazybytes.demo.entity.Account;
import com.eazybytes.demo.entity.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID roleId;

    @Column(name = "company_code")
    private String companyCode;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "authority_level")
    private int authorityLevel;

    @Column(name = "feature_category")
    @Enumerated(EnumType.STRING)
    private FeatureCategory featureCategory;

    @ManyToMany
    @JoinTable(name = "roles_accounts",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id"))
    private Set<Account> accounts = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Set<RoleDetail> roleDetails = new HashSet<>();

    public FeatureCategory getFeatureCategory() {
        return featureCategory;
    }

    public void setFeatureCategory(FeatureCategory featureCategory) {
        this.featureCategory = featureCategory;
    }

    public Set<RoleDetail> getRoleDetails() {
        return roleDetails;
    }

    public void setRoleDetails(Set<RoleDetail> roleDetails) {
        this.roleDetails = roleDetails;
    }

    public int getAuthorityLevel() {
        return authorityLevel;
    }

    public void setAuthorityLevel(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public enum FeatureCategory
    {
        MASTER, CUSTOMER, RESERVATION, COMMON_MASTER, CASHIER, CONTRACT, REVENUE, INVENTORY, MAIL_MAGAZINE
    }
}
