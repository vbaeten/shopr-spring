import {Component, Input, OnInit} from '@angular/core';
import {Article} from "../../../../../models/article";
import {Fiction} from "../../../../../models/fiction";
import {OrderLine} from "../../../../../models/orderLine";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {ArticleSevice} from "../../../../../services/article.sevice";
import {OrderLineService} from "../../../../../services/order-line.service";
import {Order} from "../../../../../models/order";

@Component({
  selector: 'app-fiction-details',
  templateUrl: './fiction-details.component.html',
  styleUrls: ['./fiction-details.component.css']
})
export class FictionDetailsComponent implements OnInit {

  articleId: number;
  selectedArticle: Fiction;
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
        this.selectedArticle = data as Fiction;
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
