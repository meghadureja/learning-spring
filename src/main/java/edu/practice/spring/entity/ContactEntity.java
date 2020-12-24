package edu.practice.spring.entity;

import edu.practice.spring.constants.TableConstants;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = TableConstants.CONTACT_TABLE)
public class ContactEntity extends BaseEntity{
    @Id
    @Column(name = TableConstants.CONTACT_ID)
    private Long id;
    @Size(min=5, max=200)
    private String firstName;
    private String middleName;
    private String lastName;
    private String title;
    private String company;
    @Email(message = "Email should be valid")
    private String email;
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PhoneNumberEntity> phoneNumbers; //C1->P1, C1->P2
}
