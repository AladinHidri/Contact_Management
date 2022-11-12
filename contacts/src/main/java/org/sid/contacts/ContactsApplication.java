package org.sid.contacts;

import org.sid.contacts.entities.Contact;
import org.sid.contacts.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner {

	@Autowired
	private ContactRepository contactRepository ;

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("Hidri","Alaeddine",df.parse("28/07/1997"),"aladinhidri93@gmail.com",93611482,"aladin.png"));
		contactRepository.save(new Contact("Basti","Siham",df.parse("16/11/1960"),"sihambasti@gmail.com",98562468,"siham.png"));
		contactRepository.save(new Contact("Hidri","Zina",df.parse("03/03/2007"),"zinahidri@gmail.com",93765986,"zina.png"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});

	}
}
