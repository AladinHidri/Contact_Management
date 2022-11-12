import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactsComponent } from './components/contacts/contacts.component';
import { AboutComponent } from './components/about/about.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NewContactComponent } from './components/new-contact/new-contact.component';
import { NouveauContactComponent } from './components/nouveau-contact/nouveau-contact.component';
import { EditContactComponent } from './components/edit-contact/edit-contact.component';

@NgModule({
  declarations: [AppComponent, ContactsComponent, AboutComponent, NewContactComponent, NouveauContactComponent, EditContactComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
