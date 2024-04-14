package com.eazybytes.demo.service.imp;

import com.eazybytes.demo.config.AppConfig;
import com.eazybytes.demo.dto.RoleDetailDto;
import com.eazybytes.demo.dto.RoleDto;
import com.eazybytes.demo.entity.role.Role;
import com.eazybytes.demo.mapper.RoleMapper;
import com.eazybytes.demo.reponsitory.RoleDetailReponsitory;
import com.eazybytes.demo.reponsitory.RoleReponsitory;
import com.eazybytes.demo.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImp implements RoleService {
    private AppConfig appConfig;
    private RoleDetailReponsitory roleDetailReponsitory;
    private RoleReponsitory roleReponsitory;

    public RoleServiceImp(AppConfig appConfig, RoleDetailReponsitory roleDetailReponsitory, RoleReponsitory roleReponsitory) {
        this.appConfig = appConfig;
        this.roleDetailReponsitory = roleDetailReponsitory;
        this.roleReponsitory = roleReponsitory;
    }

    public Page<RoleDto> findBySearchFieldWithQuery(int pageNum, int pageSize, int featureCategory, String searchField, String sortField, String sortDir){
        // int pageSize = appConfig.getPageSize();
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Role> list = roleReponsitory.findBySearchFieldWithQuery(featureCategory, searchField, pageable);
        // list.stream().map(item -> RoleMapper.mapToRoleDto(item));
        // return list.stream().map(item -> RoleMapper.mapToRoleDto(item));
        return list.map(item -> RoleMapper.mapToRoleDto(item));
    }

    public List<RoleDto> findByRoleNameLikeAndFeatureCategoryOrderByUpdatedAtDesc(String roleName, Role.FeatureCategory featureCategoryCode){
        List<Role> roleList = roleReponsitory.findByRoleNameLikeAndFeatureCategoryOrderByUpdatedAtDesc(roleName, featureCategoryCode);

        return roleList.stream().map(item -> RoleMapper.mapToRoleDto(item)).toList();
    }

    @Transactional
    public RoleDto saveRole(Role role){
        boolean isSaved = false;
        Role savedContact = roleReponsitory.save(role);
        return RoleMapper.mapToRoleDto(savedContact);
    }

    @Override
    public RoleDto findByRoleIdAndCompanyCode(UUID roleId, String companyCode) {
        Role savedContact = roleReponsitory.findByRoleId(roleId);
        return RoleMapper.mapToRoleDto(savedContact);
    }

    @Override
    public Role findByRoleId(UUID roleId) {
        return roleReponsitory.findByRoleId(roleId);
    }

    @Override
    public void deleteRole(UUID roleId) {
        roleReponsitory.deleteById(roleId);
    }
}
