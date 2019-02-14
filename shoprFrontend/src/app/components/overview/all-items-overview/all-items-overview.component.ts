import {Component, OnInit} from '@angular/core';
import {ItemsService} from "../../../services/items.service";
import {Item} from "../../../models/item";
import {DataService} from "../../../services/data.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-all-items-overview',
  templateUrl: './all-items-overview.component.html',
  styleUrls: ['./all-items-overview.component.css']
})
export class AllItemsOverviewComponent implements OnInit {


  items = []
  displayedColumns: string[] = ['no', 'Title', 'type', 'price', 'details']
  detailLink
  detailItem: Item

  constructor(private itemService: ItemsService, private dataService: DataService, private routerService: Router) {
  }


  ngOnInit() {

    this.itemService.getItems()
      .subscribe(data => this.items = data)

  }


  toDetailPage(toPassId) {
    this.dataService.changeId(toPassId)
    this.itemService.getItemById(toPassId).subscribe((data) => {
      this.detailItem = data
      console.log(this.detailItem)
      this.defineRouterLink(this.detailItem)
      this.navigate()
    })

  }


  navigate() {
    this.routerService.navigate([this.detailLink])
  }

  defineRouterLink(item: Item) {

    if (item.type === "Game") {
      this.detailLink = "/gameDetails"
    }
    else if (item.type === "fiction book") {
      this.detailLink = "/fictionDetails"
    }
    else if (item.type === "non-fiction book") {
      this.detailLink = "/nonFictionDetails"
    }
    else if (item.type === "Lp") {
      this.detailLink = "/lpDetails"
    }

  }

}
