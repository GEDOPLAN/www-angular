import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';

import {TableModule} from 'primeng/table';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {DropdownModule} from 'primeng/dropdown';
import {MultiSelectModule} from 'primeng/multiselect';

import {ROUTES} from './app.routes';
import {HomeComponent} from './components/home/home.component';
import {EditComponent} from './components/edit/edit.component';
import {BASE_PATH} from './api/generated';
import {environment} from '../environments/environment';

@NgModule({
  declarations: [AppComponent, HomeComponent, EditComponent],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    TableModule,
    BrowserAnimationsModule,
    ButtonModule,
    DropdownModule,
    MultiSelectModule,
    InputTextModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [
    {provide: BASE_PATH, useValue: environment.url}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
