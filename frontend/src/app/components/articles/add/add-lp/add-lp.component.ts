import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {Lp} from "../../../../models/lp";
import {LpService} from "../../../../services/lp.service";

@Component({
  selector: 'app-add-lp',
  templateUrl: './add-lp.component.html',
  styleUrls: ['./add-lp.component.css']
})
export class AddLpComponent implements OnInit {

  lp: Lp;

  constructor(private lpService: LpService) { }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    this.lp = new Lp();
    this.lp.title = form.value.title;
    this.lp.artist = form.value.artist;
    this.lp.genre = form.value.genre;
    this.lp.price = form.value.price;
    this.lp.supplier = form.value.supplier;
    this.lp.type = 'Lp';
    this.lpService.addLp(this.lp).subscribe(data => this.lp = data);
  }
}
