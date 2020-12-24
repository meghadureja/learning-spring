package edu.practice.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    private Date createdDate;
    private Date updatedDate;
    private String createdBy;
    private String updatedBy;
    private Boolean activeFlag;
}
