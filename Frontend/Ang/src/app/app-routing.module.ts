import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './homeC/home/home.component';
import { EditComponent } from './addEdit/edit/edit.component';
import { AddComponent } from './addEdit/add/add.component';
import { ErrorComponent } from './error/error/error.component';
import { PreventivoComponent } from './preventivo/preventivo/preventivo.component';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './registration/register/register.component';


const routes: Routes = [
  {path:"" , component: LoginComponent,},
  {path:"login" , component: LoginComponent,},
  {path:"register" , component: RegisterComponent,},
  {path:"home" , component: HomeComponent,},
  {path:"preventivo" , component: PreventivoComponent},
  {path:"edit/:codProdotto" , component: EditComponent,},
  {path:"edit" , component: ErrorComponent,},
  {path:"add" , component: AddComponent,},
  {path:'**', component: ErrorComponent}//da finire
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
