package edu.practice.spring.entity;

import edu.practice.spring.constants.TableConstants;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = TableConstants.PHONE_NUMBER_TABLE)
public class PhoneNumberEntity extends BaseEntity {
    @Id
    @Column(name = TableConstants.PHONE_NUMBER_ID)
    private Long id;
    private String type;
    private String number;
    private String primaryIndicator;
}
