package edu.practice.spring.entity;

import edu.practice.spring.constants.TableConstants;
import lombok.Data;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name="contact_id")
    private ContactEntity contact; //P1->C1, P2->C1
}
