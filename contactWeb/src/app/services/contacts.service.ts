import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { Contact } from '../models/contact.model';
@Injectable({
  providedIn: 'root',
})
export class ContactsService {
  constructor(public http: HttpClient) {}

  getContacts(motCle: string, page: number, size: number) {
    return this.http
      .get(
        'http://localhost:8085/chercherContacts?mc=' +
          motCle +
          '&size=' +
          size +
          '&page=' +
          page
      )
      .pipe(map((resp) => resp));
  }
  saveContact(contact: Contact) {
    return this.http
      .post('http://localhost:8085/contacts', contact)
      .pipe(map((resp) => resp));
  }
  updateContact(contact: Contact) {
    return this.http
      .put('http://localhost:8085/contacts/' + contact.id, contact)
      .pipe(map((resp) => resp));
  }
  getContact(id: number) {
    return this.http
      .get('http://localhost:8085/contact/' + id)
      .pipe(map((resp) => resp));
  }
  delteContact(id: number) {
    return this.http
      .delete('http://localhost:8085/contacts/' + id)
      .pipe(map((resp) => resp));
  }
}
