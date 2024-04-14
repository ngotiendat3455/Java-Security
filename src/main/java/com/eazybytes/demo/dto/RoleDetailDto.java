package com.eazybytes.demo.dto;

import com.eazybytes.demo.entity.BaseEntity;
import com.eazybytes.demo.entity.role.Feature;
import com.eazybytes.demo.entity.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class RoleDetailDto {
    private String featureCode;
    private boolean useMailSend;
    private boolean mailSend;
    private boolean useOutput;
    private boolean possibleToOutput;
    private boolean useImport;
    private boolean possibleToImport;
    private int accessLevel;
    private String followOrgId;
    private String[] followOrganizationName;
    private boolean useOrganize;
    private boolean edit;
    private UUID roleDetailId;
    // private boolean isDisabled;
    private boolean possibleToManagerItem;
    private boolean possibleToOutputExcel;
    private boolean possibleToOutputPdf;
    @JsonIgnore
    private Role role;

    @JsonIgnore
    private String companyCode;

    public RoleDetailDto(String featureCode, boolean possibleToOutput, boolean possibleToImport, boolean edit, int accessLevel, String followOrgId, UUID roleDetailId, Role role, String companyCode) {
        this.featureCode = featureCode;
//        this.useMailSend = useMailSend;
//        this.mailSend = mailSend;
        this.useOutput = possibleToOutput;
        this.possibleToOutput = possibleToOutput;
        this.useImport = possibleToImport;
        this.possibleToImport = possibleToImport;
        this.accessLevel = accessLevel;
        this.followOrgId = followOrgId;
        // this.followOrganizationName = followOrganizationName;
        this.useOrganize = followOrgId != null && !followOrgId.isEmpty();
        this.edit = edit;
        this.roleDetailId = roleDetailId;
        this.role = role;
        // this.isDisabled = isDisabled;
        // this.possibleToManagerItem = possibleToManagerItem;
        this.possibleToOutputExcel = edit;
        this.possibleToOutputPdf = edit;
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public void setUseMailSend(boolean useMailSend) {
        this.useMailSend = useMailSend;
    }

    public void setMailSend(boolean mailSend) {
        this.mailSend = mailSend;
    }

    public void setUseOutput(boolean useOutput) {
        this.useOutput = useOutput;
    }

    public void setPossibleToOutput(boolean possibleToOutput) {
        this.possibleToOutput = possibleToOutput;
    }

    public void setUseImport(boolean useImport) {
        this.useImport = useImport;
    }

    public void setPossibleToImport(boolean possibleToImport) {
        this.possibleToImport = possibleToImport;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setFollowOrgId(String followOrgId) {
        this.followOrgId = followOrgId;
    }

    public void setFollowOrganizationName(String[] followOrganizationName) {
        this.followOrganizationName = followOrganizationName;
    }

    public void setUseOrganize(boolean useOrganize) {
        this.useOrganize = useOrganize;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void setRoleDetailId(UUID roleDetailId) {
        this.roleDetailId = roleDetailId;
    }

//    public void setDisabled(boolean disabled) {
//        isDisabled = disabled;
//    }

    public void setPossibleToManagerItem(boolean possibleToManagerItem) {
        this.possibleToManagerItem = possibleToManagerItem;
    }

    public void setPossibleToOutputExcel(boolean possibleToOutputExcel) {
        this.possibleToOutputExcel = possibleToOutputExcel;
    }

    public void setPossibleToOutputPdf(boolean possibleToOutputPdf) {
        this.possibleToOutputPdf = possibleToOutputPdf;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public boolean isUseMailSend() {
        return useMailSend;
    }

    public boolean isMailSend() {
        return mailSend;
    }

    public boolean isUseOutput() {
        return useOutput;
    }

    public boolean isPossibleToOutput() {
        return possibleToOutput;
    }

    public boolean isUseImport() {
        return useImport;
    }

    public boolean isPossibleToImport() {
        return possibleToImport;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public String getFollowOrgId() {
        return followOrgId;
    }

    public String[] getFollowOrganizationName() {
        return followOrganizationName;
    }

    public boolean isUseOrganize() {
        return useOrganize;
    }

    public boolean isEdit() {
        return edit;
    }

    public UUID getRoleDetailId() {
        return roleDetailId;
    }


//    public boolean isDisabled() {
//        return isDisabled;
//    }

    public boolean isPossibleToManagerItem() {
        return possibleToManagerItem;
    }

    public boolean isPossibleToOutputExcel() {
        return possibleToOutputExcel;
    }

    public boolean isPossibleToOutputPdf() {
        return possibleToOutputPdf;
    }
}
