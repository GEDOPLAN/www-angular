export * from './author.service';
import {AuthorService} from './author.service';
import {BookService} from './book.service';
import {PublisherService} from './publisher.service';

export * from './book.service';
export * from './publisher.service';
export const APIS = [AuthorService, BookService, PublisherService];
