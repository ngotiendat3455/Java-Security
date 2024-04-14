package com.eazybytes.demo.mapper;

import com.eazybytes.demo.dto.RoleDetailDto;
import com.eazybytes.demo.entity.role.RoleDetail;

public class RoleDetailMapper {
    public static RoleDetailDto mapToRoleDetailDto(RoleDetail role) {

        return new RoleDetailDto(
                role.getFeatureCode(),
                role.isPossibleToOutput(),
                role.isPossibleToImport(),
                role.isEdit(),
                role.getAccessLevel(),
                role.getFollowOrgId(),
                role.getRoleDetailId(),
                role.getRole(),
                role.getCompanyCode()
        );
    }

    public static RoleDetail mapAddToRoleDetail(RoleDetailDto dto) {

        return new RoleDetail(
                dto.getRole(),
                dto.getFeatureCode(),
                dto.getAccessLevel(),
                dto.isEdit(),
                dto.isPossibleToImport(),
                dto.isPossibleToOutput(),
                dto.getFollowOrgId()
        );
    }

    public static RoleDetail mapUpdateToRoleDetail(RoleDetailDto dto) {
        return new RoleDetail(
                dto.getRole(),
                dto.getRoleDetailId(),
                dto.getFeatureCode(),
                dto.getAccessLevel(),
                dto.isEdit(),
                dto.isPossibleToImport(),
                dto.isPossibleToOutput(),
                dto.getFollowOrgId()
        );
    }
}
