import {Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {EditComponent} from './components/edit/edit.component';

export const ROUTES: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {
    path: 'home',
    component: HomeComponent,
    children: [{path: ':id', component: EditComponent}]
  }
];
