import {Component, Input, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {GameService} from "../../services/game.service";
import {ItemsService} from "../../services/items.service";
import {Review} from "../../models/review";
import {ReviewService} from "../../services/review.service";

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {


  @Input() item
  reviews = []
  review:Review= new Review()


  constructor(private reviewService:ReviewService) {
  }

  ngOnInit() {

      this.reviewService.getReviewsByItemId(this.item.id).subscribe(data=>this.reviews=data)


  }

  addReview(form: NgForm) {
    this.review=new Review()
    this.review.description=form.value.description
    this.review.score=form.value.score
    this.reviews.push(this.review)
    this.reviewService.addReview(this.review).subscribe(data=>this.review=data)
  }


}
