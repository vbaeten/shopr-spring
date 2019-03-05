import {Injectable} from "@angular/core";
import {MatSnackBar} from "@angular/material";
import {ApiService} from "./api.service";
import {Lp} from "../models/lp";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LpService {
  constructor(private notification: MatSnackBar, private apiService: ApiService) {
  }

  public createLp(lp: Lp) {
    this.apiService.doPost("/lp", lp).subscribe(response => {
        this.notification.open("New lp created", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Lp has not been created, try again! 👎", {duration: 3000});
      })
  };

  public edit(id: number, lp: Lp) {
    this.apiService.doPut("/lp/" + id, lp).subscribe(response => {
        this.notification.open("Lp has been updated", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Lp has not been updated, try again! 👎", {duration: 3000});
      })
  }

  public getLps() {
    return this.apiService.doGet("/lp")
  }

  public deleteLp(id: number) {
    return this.apiService.doDelete("/lp/" + id)
  }

  public getLpById(id: number): Observable<Lp> {
    return this.apiService.doGet("/lp/" + id);
  }
}
