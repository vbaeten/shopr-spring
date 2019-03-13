import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Lp} from '../../../../models/lp';
import {LpService} from '../../../../services/lp.service';

@Component({
  selector: 'app-add-lp',
  templateUrl: './add-lp.component.html',
  styleUrls: ['./add-lp.component.css']
})
export class AddLpComponent implements OnInit {

  lp: Lp;
  addLpForm: FormGroup;

  constructor(private lpService: LpService) { }

  ngOnInit() {
    this.addLpForm = new FormGroup({
      title: new FormControl(''),
      artist: new FormControl(''),
      genre: new FormControl(''),
      price: new FormControl(''),
      supplier: new FormControl('')
    });
  }

  onSubmit() {
    this.lp = new Lp();
    this.lp.title = this.addLpForm.value.title;
    this.lp.artist = this.addLpForm.value.artist;
    this.lp.genre = this.addLpForm.value.genre;
    this.lp.price = this.addLpForm.value.price;
    this.lp.supplier = this.addLpForm.value.supplier;
    this.lp.type = 'Lp';
    this.lpService.addLp(this.lp).subscribe(data => this.lp = data);
  }
}
