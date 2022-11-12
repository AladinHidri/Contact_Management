import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Contact } from 'src/app/models/contact.model';
import { ContactsService } from 'src/app/services/contacts.service';

@Component({
  selector: 'app-edit-contact',
  templateUrl: './edit-contact.component.html',
  styleUrls: ['./edit-contact.component.css'],
})
export class EditContactComponent implements OnInit {
  mode: number = 1;
  idContact: number;
  contact: any = new Contact();
  constructor(
    public activatedRoute: ActivatedRoute,
    private contactsService: ContactsService,
    private router: Router
  ) {
    this.idContact = activatedRoute.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.contactsService.getContact(this.idContact).subscribe(
      (data) => {
        this.contact = data;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  updateContact() {
    this.contactsService.updateContact(this.contact).subscribe(
      (data) => {
        console.log(data);
        alert('Mise à jour effectuée');
        this.router.navigate(['contacts']);
      },
      (err) => {
        console.log(err);
        alert('Probléme');
      }
    );
  }
}
