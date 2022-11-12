package org.sid.contacts.services;

import org.sid.contacts.entities.Contact;
import org.sid.contacts.exceptions.ContactNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContactService {
    List<Contact> getContacts() ;
    Contact getContact(Long id) throws ContactNotFoundException;

    Contact saveContact(Contact contact);

    Boolean deleteContact(Long id) throws ContactNotFoundException;

    Contact updateContact(Contact contact);

    Page<Contact> chercherContact(String mc, int page, int size);
}
