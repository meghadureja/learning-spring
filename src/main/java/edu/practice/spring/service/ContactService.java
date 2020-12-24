package edu.practice.spring.service;

import edu.practice.spring.domain.ContactDTO;
import edu.practice.spring.entity.ContactEntity;
import edu.practice.spring.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactDTO addContact(ContactDTO dto) {
        //mapper
        ContactEntity contact = new ContactEntity();
        ContactEntity savedContact = contactRepository.save(contact);
        dto.setId(savedContact.getId());
        return dto;
    }

    public ContactDTO updateContact(ContactDTO dto) {
        //mapper
        ContactEntity contact = new ContactEntity();
        ContactEntity savedContact = contactRepository.save(contact);
        dto.setId(savedContact.getId());
        return dto;
    }

    public ContactDTO getContact(ContactDTO dto) {
        Optional<ContactEntity> contactEntity = contactRepository.findById(dto.getId());
        if(contactEntity.isPresent()){
            ContactEntity contact = contactEntity.get();
            //mapper
            dto.setId(contact.getId());
            return dto;
        }
        return null;
    }

    public void deleteContact(ContactDTO dto) {
        Optional<ContactEntity> contactEntity = contactRepository.findById(dto.getId());
        if(contactEntity.isPresent()){
            ContactEntity contact = contactEntity.get();
            contactRepository.delete(contact);
        }
    }

}
