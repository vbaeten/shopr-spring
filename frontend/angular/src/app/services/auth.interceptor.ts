import {Injectable} from "@angular/core";
import {HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {TokenStorage} from "./token.storage";
import {Router} from "@angular/router";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private tokenStorage: TokenStorage, private router:Router) {

  }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    let httpHeader: HttpHeaders = new HttpHeaders();
    httpHeader= httpHeader.set('Authorization', this.tokenStorage.getToken());
    httpHeader= httpHeader.set('X-Requested-With', "XMLHttpRequest");
    const auth = req.clone({
      headers: httpHeader
    });
    return next.handle(auth);
  }
}
