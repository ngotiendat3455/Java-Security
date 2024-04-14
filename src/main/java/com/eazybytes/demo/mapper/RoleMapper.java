package com.eazybytes.demo.mapper;

import com.eazybytes.demo.dto.RoleDetailDto;
import com.eazybytes.demo.dto.RoleDto;
import com.eazybytes.demo.entity.role.Role;
import com.eazybytes.demo.entity.role.RoleDetail;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoleMapper {
    public static RoleDto mapToRoleDto(Role role){

        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName(role.getRoleName());
        roleDto.setRoleId(role.getRoleId());
        roleDto.setCompanyCode(role.getCompanyCode());
        roleDto.setAuthorityLevel(Optional.of(role.getAuthorityLevel()));
        Set<RoleDetail> roleDetails= role.getRoleDetails();
        Stream<RoleDetailDto> roleResponses = roleDetails.stream().map(RoleDetailMapper::mapToRoleDetailDto);
        List<RoleDetailDto> listDto = roleResponses.collect(Collectors.toList());
        roleDto.setRoleResponses(listDto);
        return roleDto;
    }

    public static Role mapToRole(RoleDto dto){
        Role role = new Role();
        role.setAuthorityLevel(dto.getAuthorityLevel().get());
        role.setRoleName(dto.getRoleName());
        role.setRoleId(dto.getRoleId());
        role.setCompanyCode(dto.getCompanyCode());
        role.setFeatureCategory(dto.getFeatureCategory());
        List<RoleDetailDto> listDto = dto.getRoleResponses();
        Set<RoleDetail> roleDetails= new HashSet<>();
        listDto.forEach(dtoLocal -> {
            RoleDetail roleDetail = RoleDetailMapper.mapUpdateToRoleDetail(dtoLocal);
            roleDetail.setRole(role);
            roleDetail.setCompanyCode(dto.getCompanyCode());
            roleDetails.add(roleDetail);
        });
        role.setRoleDetails(roleDetails);
        return role;
    }
}
