import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import {UsersModModule} from './users-mod/users-mod.module'

import{FormsModule} from "@angular/forms"
@NgModule({
  declarations: [
    AppComponent,
    UsersComponent
  ],
  imports: [  
    BrowserModule,
    AppRoutingModule,
    UsersModModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
