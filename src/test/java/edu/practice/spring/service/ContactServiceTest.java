package edu.practice.spring.service;

import edu.practice.spring.domain.ContactDTO;
import edu.practice.spring.entity.ContactEntity;
import edu.practice.spring.repository.ContactRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;

public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;
    private ContactService contactService;

    @Test
    public void should_create_contact(){
        ContactEntity entity = new ContactEntity();
        ContactEntity savedContact = new ContactEntity();
        savedContact.setId(1L);
        doReturn(savedContact).when(contactRepository).save(entity);
        ContactDTO contactDTO = contactService.addContact(new ContactDTO());
        assertEquals(savedContact.getId(), contactDTO.getId()); //expected,actual
    }

    @Test
    public void should_update_contact(){
        ContactEntity entity = new ContactEntity();
        ContactEntity savedContact = new ContactEntity();
        savedContact.setId(1L);
        doReturn(savedContact).when(contactRepository).save(entity);
        ContactDTO contactDTO = contactService.updateContact(new ContactDTO());
        assertEquals(savedContact.getId(), contactDTO.getId());
    }

    @Test
    public void should_delete_contact(){
        ContactEntity contact = new ContactEntity();
        contact.setId(1L);
        Optional<ContactEntity> contactOptional = Optional.of(contact);
        ContactDTO dto = new ContactDTO();
        dto.setId(1L);
        doReturn(contactOptional).when(contactRepository).findById(dto.getId());
        contactService.deleteContact(dto);
        assertEquals(dto.getId(), contact.getId());
    }

    @Test
    public void should_throw_null_when_contact_is_not_present(){
        Optional<ContactEntity> contact = Optional.empty();
        ContactDTO dto = new ContactDTO();
        dto.setId(2L);
        doReturn(contact).when(contactRepository).findById(dto.getId());
        dto = contactService.getContact(dto);
        assertNull(dto);
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // this is needed for initialization of mocks, if you use @Mock
        contactService = new ContactService(contactRepository);
    }
}
