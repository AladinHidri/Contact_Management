package org.sid.contacts.web;
import lombok.AllArgsConstructor;
import org.sid.contacts.entities.Contact;
import org.sid.contacts.exceptions.ContactNotFoundException;
import org.sid.contacts.repositories.ContactRepository;
import org.sid.contacts.services.ContactService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ContactRestController {
    private ContactService contactService ;
    private ContactRepository contactRepository;
    @GetMapping("/contacts")
    public List<Contact> getContact() {
        return contactService.getContacts();
    }

    @GetMapping("/contact/{id}")
    public Contact getContact(@PathVariable Long id) throws ContactNotFoundException {
        return contactService.getContact(id);
    }

    @PostMapping("/contacts")
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact) ;
    }

    @DeleteMapping("/contacts/{id}")
    public Boolean deleteContact(@PathVariable Long id) throws ContactNotFoundException {
        return contactService.deleteContact(id);
    }

    @PutMapping("/contacts/{id}")
    public Contact updateContact(@PathVariable Long id , @RequestBody Contact contact) {
            contact.setId(id);
            return contactService.updateContact(contact);
    }

    @GetMapping("/chercherContacts")
    public Page<Contact> chercher(
            @RequestParam(name="mc",defaultValue = "") String mc ,
            @RequestParam(name="page",defaultValue = "0") int page,
            @RequestParam(name="size" , defaultValue = "5") int size
    ) {
       return contactService.chercherContact("%"+mc+"%",page,size);
    }

    }

