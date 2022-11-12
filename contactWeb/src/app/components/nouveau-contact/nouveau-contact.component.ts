import { Component, OnInit } from '@angular/core';
import { ContactsService } from 'src/app/services/contacts.service';

@Component({
  selector: 'app-nouveau-contact',
  templateUrl: './nouveau-contact.component.html',
  styleUrls: ['./nouveau-contact.component.css'],
})
export class NouveauContactComponent implements OnInit {
  constructor(private contactService: ContactsService) {}

  ngOnInit(): void {}

  onSaveContact(dataForm) {
    this.contactService.saveContact(dataForm).subscribe(
      (data) => {
        console.log(data);
      },
      (err) => {
        console.log(JSON.parse(err.body).message);
      }
    );
  }
}
