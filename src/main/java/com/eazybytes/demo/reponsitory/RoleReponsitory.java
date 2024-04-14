package com.eazybytes.demo.reponsitory;

import com.eazybytes.demo.entity.role.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoleReponsitory extends JpaRepository<Role, UUID> {
    @Query("SELECT c FROM Role c WHERE c.roleName = :searchField and c.featureCategory = :featureCategory")
        //@Query(value = "SELECT * FROM contact_msg c WHERE c.status = :status",nativeQuery = true)
    Page<Role> findBySearchFieldWithQuery(@Param("featureCategory") int featureCategory, @Param("searchField") String searchField ,Pageable pageable);

    // @Query("SELECT c FROM Role c WHERE c.roleName like %:searchField% and c.featureCategory = :featureCategory order by c.updatedAt desc")
    List<Role> findByRoleNameLikeAndFeatureCategoryOrderByUpdatedAtDesc(@Param("searchField") String roleName,@Param("featureCategory") Role.FeatureCategory featureCategory);
    Role findByRoleId(UUID roleId);
}
