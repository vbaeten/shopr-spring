import { Component, OnInit } from '@angular/core';
import {ItemsService} from "../../../services/items.service";
import {Item} from "../../../models/item";

@Component({
  selector: 'app-all-items-overview',
  templateUrl: './all-items-overview.component.html',
  styleUrls: ['./all-items-overview.component.css']
})
export class AllItemsOverviewComponent implements OnInit {



  items = []
  displayedColumns: string[] =['no', 'Title', 'price','type']

  constructor(private itemService:ItemsService) { }


  ngOnInit() {

    this.itemService.getItems()
      .subscribe(data=>this.items=data)

  }

}
