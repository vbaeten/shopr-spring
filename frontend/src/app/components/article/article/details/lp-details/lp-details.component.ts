import { Component, OnInit } from '@angular/core';
import {Lp} from "../../../../../models/lp";
import {ActivatedRoute} from "@angular/router";
import {ArticleSevice} from "../../../../../services/article.sevice";
import {OrderLine} from "../../../../../models/orderLine";
import {Order} from "../../../../../models/order";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {OrderLineService} from "../../../../../services/order-line.service";

@Component({
  selector: 'app-lp-details',
  templateUrl: './lp-details.component.html',
  styleUrls: ['./lp-details.component.css']
})
export class LpDetailsComponent implements OnInit {
  articleId: number;
  selectedArticle: Lp;
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
        this.selectedArticle = data as Lp;
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
        order.orderLines.push(newOrderLine);
        localStorage.setItem('currentOrder', JSON.stringify(order));
      });

  }

}
