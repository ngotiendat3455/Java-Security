package com.eazybytes.demo.controller;

import com.eazybytes.demo.dto.CreateAndUpdateResponse;
import com.eazybytes.demo.dto.IGetDetailRequest;
import com.eazybytes.demo.dto.RoleDetailDto;
import com.eazybytes.demo.dto.RoleDto;
import com.eazybytes.demo.entity.role.Role;
import com.eazybytes.demo.filter.AuthoritiesLoggingAfterFilter;
import com.eazybytes.demo.mapper.RoleMapper;
import com.eazybytes.demo.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@RequestMapping("/api/v1/role")
@RestController
public class RoleController {
    private final Logger LOG =
            Logger.getLogger(AuthoritiesLoggingAfterFilter.class.getName());
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping( "/getAll")
    public ResponseEntity<List<RoleDto>> getRoles(
            @RequestParam("featureCategory") String featureCategory,
            @RequestParam("roleName") Optional<String> roleName
    ){
        LOG.info("test role " + featureCategory);
        LOG.info("test role " + roleName);
        List<RoleDto> list = this.roleService.findByRoleNameLikeAndFeatureCategoryOrderByUpdatedAtDesc('%' + roleName.orElse("") + '%', Role.FeatureCategory.valueOf(featureCategory));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CreateAndUpdateResponse<RoleDto>> createRole(@RequestBody RoleDto dto) {
        // dto.setCompanyCode(companyCode);
        RoleDto saveResult = roleService.saveRole(RoleMapper.mapToRole(dto));
        String message = saveResult.getRoleId() != null ? "Role created successfully" : "Role created unsuccessfully";
        if(saveResult.getRoleId() != null) {
            CreateAndUpdateResponse<RoleDto> response = new CreateAndUpdateResponse<RoleDto>(message, false);
            response.setData(Optional.of(saveResult));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        CreateAndUpdateResponse<RoleDto> response = new CreateAndUpdateResponse<RoleDto>(message, true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<CreateAndUpdateResponse<RoleDto>> updateRole(@RequestBody RoleDto dto, @PathVariable("roleId") String roleId) {
        // dto.setCompanyCode(companyCode);
        if (UUID.fromString(roleId) != dto.getRoleId()){
            CreateAndUpdateResponse<RoleDto> response = new CreateAndUpdateResponse<RoleDto>("Wrong RoleId", true);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        Role role = roleService.findByRoleId(dto.getRoleId());
        if (role == null) {
            CreateAndUpdateResponse<RoleDto> response = new CreateAndUpdateResponse<RoleDto>("RoleId is not found", true);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        RoleDto saveResult = roleService.saveRole(RoleMapper.mapToRole(dto));
        String message = saveResult.getRoleId() != null ? "Role updated successfully" : "Role updated unsuccessfully";
        if(saveResult.getRoleId() != null) {
            CreateAndUpdateResponse<RoleDto> response = new CreateAndUpdateResponse<RoleDto>(message, false);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        CreateAndUpdateResponse<RoleDto> response = new CreateAndUpdateResponse<RoleDto>(message, true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{roleId}")
    public ResponseEntity<RoleDto> getRolesDetail(@RequestBody IGetDetailRequest orderRequest,
                                        @PathVariable("roleId") String roleId
                            ) {
        RoleDto saveResult = roleService.findByRoleIdAndCompanyCode(UUID.fromString(roleId), orderRequest.getCompanyCode());
        return new ResponseEntity<>(saveResult, HttpStatus.OK);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<String> deleteRolesDetail(@PathVariable("roleId") String roleId) {
        if (roleService.findByRoleId(UUID.fromString(roleId)) == null) {
            return new ResponseEntity<>("RoleId not found",HttpStatus.NOT_FOUND);
        }
        roleService.deleteRole(UUID.fromString(roleId));
        return new ResponseEntity<>("Delete successfully",HttpStatus.OK);
    }
}
