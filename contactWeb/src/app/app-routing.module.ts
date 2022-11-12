import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { ContactsComponent } from './components/contacts/contacts.component';
import { EditContactComponent } from './components/edit-contact/edit-contact.component';
import { NewContactComponent } from './components/new-contact/new-contact.component';
import { NouveauContactComponent } from './components/nouveau-contact/nouveau-contact.component';

const routes: Routes = [
  { path: 'about', component: AboutComponent },
  { path: 'contacts', component: ContactsComponent },
  { path: 'new-contact', component: NewContactComponent },
  { path: 'editContact/:id', component: EditContactComponent },
  { path: '', redirectTo: '/about', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
