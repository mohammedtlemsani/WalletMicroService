import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {WalletsComponent} from "./wallets/wallets.component";
import {TransferComponent} from "./transfer/transfer.component";

const routes: Routes = [
  {component: WalletsComponent, path: 'wallets'},
  {component: TransferComponent, path: 'transfer'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
