package com.asredanesh.sample.service.interfaces;

import com.asredanesh.sample.domain.Contact;

import java.util.List;


public interface ContactService {
    Contact save(Contact contact);

    List<Contact> findAll(Contact contact);
}
