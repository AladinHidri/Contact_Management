package org.sid.contacts.services;
import lombok.AllArgsConstructor;
import org.sid.contacts.entities.Contact;
import org.sid.contacts.exceptions.ContactNotFoundException;
import org.sid.contacts.repositories.ContactRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;


    @Override
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContact(Long id) throws ContactNotFoundException {
        return contactRepository.findById(id).orElseThrow(
                () -> new ContactNotFoundException("Contact Not Found")
        );
    }

    @Override
    public Contact saveContact(Contact contact) {
        Contact savedContact = contactRepository.save(contact) ;
        return savedContact ;
    }

    @Override
    public Boolean deleteContact(Long id) throws ContactNotFoundException {
        Contact contact = contactRepository.findById(id).orElseThrow(
                () -> new ContactNotFoundException("Contact Not found")
        );
        contactRepository.delete(contact);
        return true ;
    }

    @Override
    public Contact updateContact(Contact contact) {
        Contact savedContact = contactRepository.save(contact);
        return savedContact;
    }
    @Override
    public Page<Contact> chercherContact(String mc, int page, int size) {
        Page <Contact> pageContact= contactRepository.chercher(mc , PageRequest.of(page,size));
        return pageContact;
    }


}
