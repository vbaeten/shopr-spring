import {Component, OnInit} from '@angular/core';
import {DataService} from "../../../services/data.service";
import {FictionService} from "../../../services/fiction.service";
import {NgForm} from "@angular/forms";
import {Orderline} from "../../../models/Orderline";
import {OrderLineService} from "../../../services/order-line.service";
import {Router} from "@angular/router";
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-fictions-detail',
  templateUrl: './fictions-detail.component.html',
  styleUrls: ['./fictions-detail.component.css']
})
export class FictionsDetailComponent implements OnInit {

  passedId: number
  fiction
  orderLine
  currentUser

  constructor(private dataService: DataService,
              private fictionService: FictionService,
              private orderLineService: OrderLineService,
              private router: Router,
              private userService: UserService) {
  }


  ngOnInit() {
    this.dataService.detailId.subscribe(id => this.passedId = id)
    this.fictionService.getById(this.passedId).subscribe((fiction) => {
      this.fiction = fiction
      this.currentUser = this.userService.getCurrentUser()
      if(this.currentUser.orderLines==undefined){
        this.currentUser.orderLines=new Array()
      }
    })

  }


  delete() {
    this.fictionService.deleteById(this.passedId).subscribe(fiction => this.fiction = fiction)
  }


  addToCart(form: NgForm) {

    this.orderLine = new Orderline()
    this.orderLine.item = this.fiction
    this.orderLine.quantity = form.value.quantity
    this.orderLine.subTotal = this.orderLine.quantity * this.fiction.price

    this.currentUser.orderLines.push(this.orderLine)
    localStorage.setItem("1", JSON.stringify(this.currentUser))

    this.orderLineService.createOrderLine(this.orderLine).subscribe(data => this.orderLine = data)
    this.router.navigate(['/itemsOverview'])
    console.log(this.currentUser)


  }

  showSnackBar() {
    let message = 'book added to caRt!'
    let action = ''
    this.dataService.openSnackBar(message, action)
  }

}
