import {Component, OnInit} from '@angular/core';
import {LpService} from "../../services/lp.service";
import {Lp} from "../../domain/Lp";

@Component({
  selector: 'app-createlp',
  templateUrl: './createlp.component.html',
  styleUrls: ['./createlp.component.css']
})
export class CreatelpComponent implements OnInit {
  title: string;
  price: number;
  artist: string;
  supplierId: string;
  lpGenre: string;
  lpGenres: string[];

  constructor(private service: LpService) { }

  ngOnInit() {
    this.service.getLpGenres().subscribe(lpGenres => this.lpGenres = lpGenres);
  }
  submit() {
    let newLp = new Lp(this.title, 'lp', this.price, this.supplierId, this.lpGenre, this.artist );
    this.service.createLp(newLp).toPromise();
  }
}
