package com.eroskoller.practicing.accounts.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    @CreatedDate
    @Column(name = "created_at"  , updatable = false)
    private LocalDateTime createdAt;
    @CreatedBy
    @Column(name = "created_by"  ,updatable = false)
    private String createdBy;
    @LastModifiedDate
    @Column(name = "updated_at"  ,insertable = false)
    private LocalDateTime updatedAt;
    @LastModifiedBy
    @Column(name = "updated_by"  ,insertable = false)
    private String updatedBy;

}
