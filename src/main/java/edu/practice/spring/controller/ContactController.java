package edu.practice.spring.controller;

import edu.practice.spring.domain.ContactDTO;
import edu.practice.spring.exception.ContactException;
import edu.practice.spring.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/contacts")
    public ResponseEntity<ContactDTO> addContact(@RequestBody ContactDTO dto) {
        ContactDTO contactDTO = contactService.addContact(dto);
        return new ResponseEntity<>(contactDTO, HttpStatus.CREATED);
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable("id") Long id) throws ContactException {
        ContactDTO dto = new ContactDTO();
        dto.setId(id);
        ContactDTO contactDTO = contactService.getContact(dto);
        return new ResponseEntity<>(contactDTO, HttpStatus.CREATED);
    }


}
