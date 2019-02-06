import {Injectable} from "@angular/core";
import {HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from "@angular/common/http";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() {

  }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    let httpHeader: HttpHeaders;
    httpHeader = req.headers.set('X-Requested-With', "XMLHttpRequest");
    const auth = req.clone({
      headers: httpHeader
    });

    return next.handle(auth);
  }
}
