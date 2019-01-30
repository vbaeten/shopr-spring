import {Injectable} from "@angular/core";
import {HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {TokenStorage} from "./token.storage";
import {Router} from "@angular/router";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private tokenStorage: TokenStorage, private router:Router) {

  }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const auth = req.clone({
      headers: req.headers.set('Authenticate', this.tokenStorage.getToken())
    });
    return next.handle(auth);
  }
}
