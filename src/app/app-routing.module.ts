import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PaymentComponent} from './payment/payment.component'
import { TotalcostComponent } from './totalcost/totalcost.component';
import { TicketdetailsComponent } from './ticketdetails/ticketdetails.component';
import { PaymentfailedComponent } from './paymentfailed/paymentfailed.component';
import { CancelbookingComponent } from './cancelbooking/cancelbooking.component';


const routes: Routes = [
  {path:'payment', component:PaymentComponent},
  {path:'totalcost', component:TotalcostComponent},
  {path:'ticketdetails', component:TicketdetailsComponent},
  {path:'paymentfailed', component:PaymentfailedComponent},
  {path:'cancelbooking',component:CancelbookingComponent},
  {path:'',component:TotalcostComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
