package com.asredanesh.sample.service.impl;

import com.asredanesh.sample.domain.Contact;
import com.asredanesh.sample.repository.ContactRepository;
import com.asredanesh.sample.service.interfaces.ContactService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    /**
     *
     * @param contact
     * @return
     */
    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    /**
     *
     * @param requiredContact
     * @return
     */
    @Override
    public List<Contact> findAll(Contact requiredContact) {
        Contact contact = Contact
                .builder()
                .name(requiredContact.getName())
                .email(requiredContact.getEmail())
                .github(requiredContact.getGithub())
                .organization(requiredContact.getOrganization())
                .phoneNumber(requiredContact.getPhoneNumber())
                .build();
        return contactRepository.findAll(Example.of(contact));
    }
}
