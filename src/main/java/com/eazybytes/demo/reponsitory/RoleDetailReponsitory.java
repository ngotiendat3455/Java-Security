package com.eazybytes.demo.reponsitory;

import com.eazybytes.demo.entity.role.Role;
import com.eazybytes.demo.entity.role.RoleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDetailReponsitory extends JpaRepository<RoleDetail, Long> {
}
