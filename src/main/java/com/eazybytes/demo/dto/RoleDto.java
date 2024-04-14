package com.eazybytes.demo.dto;

import com.eazybytes.demo.entity.BaseEntity;
import com.eazybytes.demo.entity.role.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RoleDto{
    private UUID roleId;
    private String roleName;
    private Optional<Integer> permissionLevel;
    private List<RoleDetailDto> roleResponses;
    private Optional<Integer> authorityLevel;
    private String companyCode;
    @Enumerated(EnumType.STRING)
    private Role.FeatureCategory featureCategory;

    public Role.FeatureCategory getFeatureCategory() {
        return featureCategory;
    }

    public void setFeatureCategory(Role.FeatureCategory featureCategory) {
        this.featureCategory = featureCategory;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Optional<Integer> getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Optional<Integer> permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public List<RoleDetailDto> getRoleResponses() {
        return roleResponses;
    }

    public void setRoleResponses(List<RoleDetailDto> roleResponses) {
        this.roleResponses = roleResponses;
    }

    public Optional<Integer> getAuthorityLevel() {
        return authorityLevel;
    }

    public void setAuthorityLevel(Optional<Integer> authorityLevel) {
        this.authorityLevel = authorityLevel;
    }
}
