import {AbstractControl} from "@angular/forms";
import {AppInjector} from "../services/app-injector.service";
import {UserService} from "../services/user.service";

let error = {};

export class ValidateDuplicate {
  static isDuplicate (control: AbstractControl) {
    if (control.value) {
      let injector = AppInjector.getInjector();
      const userService = injector.get(UserService);


      userService.getUserByUserName(control.value).subscribe(user => {
        return  {validateDuplicate: true};
      }, error1 => {
        return  {validateDuplicate: false};
      });

    }
    return null;

  }
}
