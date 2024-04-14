package com.eazybytes.demo.entity.role;

import com.eazybytes.demo.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "features")
public class Feature extends BaseEntity {
//    @Id
//    @Column(name = "feature_id")
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    private UUID featureId;

    @Id
    @NotBlank(message="companyCode must not be blank")
    @Column(name = "company_code")
    private String companyCode;


    @Id
    @NotBlank(message="featureCode must not be blank")
    @Column(name = "feature_code")
    private String featureCode;

    @Id
    @NotBlank(message="categoryName must not be blank")
    @Column(name = "category_name")
    private String categoryName;

//    @OneToOne
//    @JoinColumn(name = "role_detail_id", unique = true)
//    private RoleDetail roleDetail;

//    public UUID getFeatureId() {
//        return featureId;
//    }

    public String getCompanyCode() {
        return companyCode;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

//    public void setFeatureId(UUID featureId) {
//        this.featureId = featureId;
//    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
