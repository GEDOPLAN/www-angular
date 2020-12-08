import {Component, OnChanges} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';

import {SelectItem} from 'primeng/api';
import {AuthorService, Book, BookService, PublisherService} from '../../api/generated';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnChanges {
  form: FormGroup;

  book: Book;

  authors: SelectItem[];

  publisher: SelectItem[];

  constructor(private _fb: FormBuilder, route: ActivatedRoute, public router: Router, private bookService: BookService,
              private authorService: AuthorService, private publisherService: PublisherService) {
    route.paramMap.subscribe(map => {
      const id = <any>map.get('id');
      if (id) {
        if (id >= 0) {
          this.bookService.getBook(id).subscribe(r => {
            this.book = r;
            this.initForm();
          });
        } else {
          this.book = <Book>{};
          this.initForm();
        }
      }
    });
  }

  save() {
    const formValue = this.form.getRawValue();
    this.bookService.saveBook(formValue).subscribe(() => {
      this.router.navigateByUrl('/home').then(() => {
      });
    });
  }

  ngOnChanges() {
    this.initForm();
  }

  private initForm() {
    this.form = this._fb.group({
      id: [this.book.id],
      isbn: [this.book.isbn],
      title: [this.book.title],
      publisher: [this.book.publisher],
      authors: [this.book.authors]
    });

    this.form.get('id').disable();
    this.authorService.getAuthorList().subscribe(
      r =>
        (this.authors = r.map(entry => {
          return {value: entry.id, label: entry.label};
        }))
    );
    this.publisherService.getAll().subscribe(
      r =>
        (this.publisher = r.map(entry => {
          return {value: entry.id, label: entry.publisherName};
        }))
    );
  }
}
