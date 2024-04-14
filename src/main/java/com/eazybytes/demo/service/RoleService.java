package com.eazybytes.demo.service;

import com.eazybytes.demo.dto.RoleDetailDto;
import com.eazybytes.demo.dto.RoleDto;
import com.eazybytes.demo.entity.role.Role;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    Page<RoleDto> findBySearchFieldWithQuery(int pageNum, int pageSize, int featureCategory, String searchField, String sortField, String sortDir);
    RoleDto saveRole(Role contact);
    RoleDto findByRoleIdAndCompanyCode(UUID roleId, String companyCode);
    Role findByRoleId(UUID roleId);
    void deleteRole(UUID roleId);
    List<RoleDto> findByRoleNameLikeAndFeatureCategoryOrderByUpdatedAtDesc(String roleName, Role.FeatureCategory featureCategory);
}
