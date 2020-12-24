package edu.practice.spring.entity;

import edu.practice.spring.constants.TableConstants;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = TableConstants.ADDRESS_TABLE)
public class AddressEntity extends BaseEntity {
    @Id
    @Column(name = TableConstants.ADDRESS_ID)
    private Long id;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String stateCode;
    private String zipCode;
    private String postalCode;
    private String countryCode;
}
