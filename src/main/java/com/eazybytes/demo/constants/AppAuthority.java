package com.eazybytes.demo.constants;

import com.eazybytes.demo.entity.role.Role;
import com.eazybytes.demo.entity.role.RoleDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AppAuthority implements GrantedAuthority {
    private final RoleDetail roleDetail;

    public AppAuthority(RoleDetail roleDetail) {
        this.roleDetail = roleDetail;
    }

    @Override
    public String getAuthority() {
        return this.roleDetail.getFeatureCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof AppAuthority) {
            AppAuthority sga = (AppAuthority)obj;
            return this.roleDetail.getFeatureCode().equals(sga.getAuthority());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.roleDetail.getFeatureCode().hashCode();
    }

    public String toString() {
        return this.roleDetail.getFeatureCode();
    }
}
