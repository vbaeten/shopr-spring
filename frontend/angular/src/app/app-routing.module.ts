import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'products/all', pathMatch: 'full'
  },
  {
    path: 'dashboard',
    redirectTo: 'dashboard', pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
