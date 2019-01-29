import {Component, OnInit} from '@angular/core';
import {BooknonfictionService} from "../../services/booknonfiction.service";
import {Booknonfiction} from "../../domain/Booknonfiction";
import {Router} from "@angular/router";


@Component({
  selector: 'app-createbooknonfiction',
  templateUrl: './createbooknonfiction.component.html',
  styleUrls: ['./createbooknonfiction.component.css']
})
export class CreatebooknonfictionComponent implements OnInit {
  price: number;
  title: string;
  author: string;
  supplierId: string;
  isbn: string;
  numberOfPages: number;
  booknonfictionGenre: string;
  booknonfictionGenres: string[];


  constructor(private service: BooknonfictionService, public router: Router) {

  }

  ngOnInit() {
    this.service.getBooknonfictionGenres().subscribe(booknonfictionGenres => this.booknonfictionGenres = booknonfictionGenres);
  }

  submit() {
    let newBooknonfiction = new Booknonfiction(this.title, 'booknonfiction', this.price, this.supplierId, this.author, this.isbn, this.numberOfPages, this.booknonfictionGenre);
    this.service.createBooknonfiction(newBooknonfiction).toPromise();
    this.router.navigate(['/articles'])
  }
}
