import {Component, Input, OnInit} from '@angular/core';
import {Lp} from "../../../../../models/lp";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LpGenre} from "../../../../../models/lp-genre";
import {LpService} from "../../../../../services/lp.service";

@Component({
  selector: 'app-create-lp',
  templateUrl: './create-lp.component.html',
  styleUrls: ['./create-lp.component.css']
})
export class CreateLpComponent implements OnInit {

  @Input() type: string;
  lp: Lp;
  createLpForm: FormGroup = this.formBuilder.group(
    {
      type: ['', Validators.required],
      title: ['', Validators.required],
      price: ['', Validators.required],
      supplierId: ['', Validators.required],
      publisher: ['', Validators.required],
      lpGenre: ['', Validators.required],
    });

  constructor(private lpService: LpService,
              private formBuilder: FormBuilder) {
  }

  lpGenres(): Array<string> {
    return Object.keys(LpGenre).filter(
      (type) => isNaN(<any>type) && type !== 'values'
    );
  }

  ngOnInit() {
    this.createLpForm.patchValue({type: this.type});
  }


  createLp = () => {
    this.lp = new Lp();
    this.lp.type = "lp";
    this.lp.title = this.createLpForm.value.title;
    this.lp.price = this.createLpForm.value.price;
    this.lp.supplierId = this.createLpForm.value.supplierId;
    this.lp.publisher = this.createLpForm.value.publisher;
    this.lp.lpGenre = this.createLpForm.value.lpGenre;

    this.lpService.createLp(this.lp);

  }
}
