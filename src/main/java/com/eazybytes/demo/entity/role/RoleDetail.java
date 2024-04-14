package com.eazybytes.demo.entity.role;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "role_details")
public class RoleDetail {

    public RoleDetail(Role role, String featureCode, int accessLevel, boolean edit, boolean possibleToImport, boolean possibleToOutput, String followOrgId) {
        //this.roleDetailId = roleDetailId;
        this.role = role;
        this.featureCode = featureCode;
        this.accessLevel = accessLevel;
        this.edit = edit;
        this.possibleToImport = possibleToImport;
        this.possibleToOutput = possibleToOutput;
        this.followOrgId = followOrgId;
    }

    public RoleDetail(Role role, UUID roleDetailId,String featureCode ,int accessLevel, boolean edit, boolean possibleToImport, boolean possibleToOutput, String followOrgId) {
        this.roleDetailId = roleDetailId;
        this.role = role;
        this.featureCode = featureCode;
        // this.featureId = featureId;
        this.accessLevel = accessLevel;
        this.edit = edit;
        this.possibleToImport = possibleToImport;
        this.possibleToOutput = possibleToOutput;
        this.followOrgId = followOrgId;
    }

    @Id
    @Column(name = "role_detail_id")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID roleDetailId;

//    @Column(name = "role_id")
//    private UUID roleId;
@ManyToOne
@JoinColumn(name = "role_id")
private Role role;

//    @Column(name = "feature_id")
//    private UUID featureId;

//    @OneToOne(cascade = CascadeType.ALL, targetEntity = Feature.class)
//    @JoinColumn(name = "feature_id")
//    private Feature feature;

    @JoinColumn(name = "feature_code")
    private String featureCode;
    @Column(name = "access_level")
    private int accessLevel;

    @Column(name = "edit")
    private boolean edit;

    @Column(name = "possible_to_import")
    private boolean possibleToImport;

    @Column(name = "possible_to_output")
    private boolean possibleToOutput;

    @Column(name = "follow_org_id")
    private String followOrgId;

    @Column(name = "company_code")
    private String companyCode;

    public RoleDetail() {

    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isPossibleToImport() {
        return possibleToImport;
    }

    public void setPossibleToImport(boolean possibleToImport) {
        this.possibleToImport = possibleToImport;
    }

//    public Feature getFeature() {
//        return feature;
//    }
//
//    public void setFeature(Feature feature) {
//        this.feature = feature;
//    }

    public void setRoleDetailId(UUID roleDetailId) {
        this.roleDetailId = roleDetailId;
    }

//    public void setRoleId(UUID roleId) {
//        this.roleId = roleId;
//    }

//    public void setFeatureId(UUID featureId) {
//        this.featureId = featureId;
//    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void setPossibleToOutput(boolean possibleToOutput) {
        this.possibleToOutput = possibleToOutput;
    }

    public void setFollowOrgId(String followOrgId) {
        this.followOrgId = followOrgId;
    }

    public UUID getRoleDetailId() {
        return roleDetailId;
    }

//    public UUID getRoleId() {
//        return roleId;
//    }

//    public UUID getFeatureId() {
//        return featureId;
//    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public boolean isEdit() {
        return edit;
    }

    public boolean isPossibleToOutput() {
        return possibleToOutput;
    }

    public String getFollowOrgId() {
        return followOrgId;
    }

}
