import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contact } from 'src/app/models/contact.model';
import { ContactsService } from 'src/app/services/contacts.service';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css'],
})
export class ContactsComponent implements OnInit {
  motCle: string = '';
  currentPage: number = 0;
  size: number = 5;
  pages: Array<number>;
  pageContacts: any;
  errorMessage: string;
  constructor(public contactsService: ContactsService, public router: Router) {}

  ngOnInit(): void {
    this.getContact();
  }

  getContact() {
    this.pageContacts = this.contactsService
      .getContacts(this.motCle, this.currentPage, this.size)
      .subscribe((data) => {
        this.pageContacts = data;
        this.pages = new Array(data['totalPages']);
        console.log(data);
        console.log(this.pages);
      });
  }

  chercher() {
    this.getContact();
  }

  gotoPage(i: number) {
    this.currentPage = i;
    this.getContact();
  }

  onEditContact(id: number) {
    this.router.navigate(['editContact', id]);
  }

  onDeleteContact(c: Contact) {
    let confirm: boolean = window.confirm('Est vous sure?');
    if (confirm == true) {
      this.contactsService.delteContact(c.id).subscribe(
        (data) => {
          this.pageContacts.content.splice(
            this.pageContacts.content.indexOf(c),
            1
          );
        },
        (err) => {
          console.log(err);
        }
      );
    }
  }
}
