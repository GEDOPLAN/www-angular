import {Component} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {BookOverviewDTO, BookService} from '../../api/generated';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  books: BookOverviewDTO[];

  constructor(public service: BookService, route: ActivatedRoute) {
    this.init();
    route.url.subscribe(() => {
      this.init();
    });
  }

  init() {
    this.service.getBooks().subscribe(b => {
      this.books = b;
    });
  }

  delete(b: BookOverviewDTO) {
    this.service.deleteBook(b.id).subscribe(r => {
      console.log(r);
      this.init();
    });
  }
}
