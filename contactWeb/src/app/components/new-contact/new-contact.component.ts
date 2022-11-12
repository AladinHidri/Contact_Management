import { Component, OnInit } from '@angular/core';
import { Contact } from 'src/app/models/contact.model';
import { ContactsService } from 'src/app/services/contacts.service';

@Component({
  selector: 'app-new-contact',
  templateUrl: './new-contact.component.html',
  styleUrls: ['./new-contact.component.css'],
})
export class NewContactComponent implements OnInit {
  contact: any = new Contact();
  mode: number = 1;
  constructor(private contactService: ContactsService) {}

  ngOnInit(): void {}

  saveContact() {
    this.contactService.saveContact(this.contact).subscribe(
      (data) => {
        this.contact = data;
        this.mode = 2;
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
