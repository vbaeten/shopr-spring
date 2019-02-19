import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ArticleSevice} from "../../../../../services/article.sevice";
import {Article} from "../../../../../models/article";
import {Game} from "../../../../../models/game";
import {OrderLineService} from "../../../../../services/order-line.service";
import {OrderLine} from "../../../../../models/orderLine";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Order} from "../../../../../models/order";

@Component({
  selector: 'app-game-details',
  templateUrl: './game-details.component.html',
  styleUrls: ['./game-details.component.css']
})
export class GameDetailsComponent implements OnInit{
  articleId: number;
  selectedArticle: Game;
  orderLine: OrderLine;
  quantity: number;
  submitQuantityForm: FormGroup = this.formBuilder.group(
    {
      quantity: ['', Validators.required]
    });

  constructor(private route: ActivatedRoute, private articleService: ArticleSevice, private orderLineService: OrderLineService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.articleId = +params['id'];
      this.articleService.getArticleById(this.articleId).subscribe(data => {
        this.selectedArticle = data as Game;
      })
    })
  }

  submitQuantity(){
    this.orderLine = new OrderLine();
    this.orderLine.quantity = this.submitQuantityForm.value.quantity;
    let order:Order = JSON.parse(localStorage.getItem('currentOrder'));
    if(order.orderId != null ){
      this.orderLine.order = order;
    }

    this.orderLine.article = this.selectedArticle;
    this.orderLine.subtotal = this.submitQuantityForm.value.quantity * this.selectedArticle.price;
    this.orderLineService.createOrderLine(this.orderLine)
      .subscribe(newOrderLine => {
        localStorage.setItem('currentOrderLine', JSON.stringify(newOrderLine));
        localStorage.setItem('currentOrder', JSON.stringify(order));
      });

  }

}
