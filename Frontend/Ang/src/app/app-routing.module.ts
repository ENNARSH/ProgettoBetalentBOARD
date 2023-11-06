import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './homeC/home/home.component';
import { EditComponent } from './addEdit/edit/edit.component';
import { AddComponent } from './addEdit/add/add.component';
import { AppComponent } from './app.component';
import { ErrorComponent } from './error/error/error.component';

const routes: Routes = [
  {path:"" , component: HomeComponent,},
  {path:"home" , component: HomeComponent,},
  {path:"edit/:codProdotto" , component: EditComponent,},
  {path:"edit" , component: EditComponent,},
  {path:"add" , component: AddComponent,},
  {path:'**', component: ErrorComponent}//da finire
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
