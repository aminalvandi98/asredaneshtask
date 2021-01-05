package com.asredanesh.sample.controller;

import com.asredanesh.sample.domain.Contact;
import com.asredanesh.sample.service.interfaces.ContactService;
import com.asredanesh.sample.service.interfaces.GithubService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private ContactService contactService;
    private GithubService githubService;

    public ContactController(ContactService contactService, GithubService githubService) {
        this.contactService = contactService;
        this.githubService = githubService;
    }

    @PutMapping("/save")
    public Contact addNewContact(@RequestBody Contact contact) {
        contact.setGithubList(githubService.getDataFromGithubAPI(contact.getGithub()));
        return contactService.save(contact);
    }

    @PostMapping("/search")
    public List<Contact> searchContact(@RequestBody Contact contact) {
        return contactService.findAll(contact);
    }
}
