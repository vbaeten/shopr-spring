import {Injectable} from "@angular/core";
import {MatSnackBar} from "@angular/material";
import {ApiService} from "./api.service";
import {Lp} from "../models/lp";

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

  public edit(lp: Lp) {
    this.apiService.doPut("/lp", lp).subscribe(response => {
        this.notification.open("Lp has been updated", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Lp has not been updated, try again! 👎", {duration: 3000});
      })
  }

  public getLps(): Promise<Lp[]> {
    return this.apiService.doGet("/lp")
      .toPromise()
      .catch(error => LpService.handleError(error))
  }

  private static handleError(error: any): Promise<any> {
    return Promise.reject(error.message | error);
  }
}
