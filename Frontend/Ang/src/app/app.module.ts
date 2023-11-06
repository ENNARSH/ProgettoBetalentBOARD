import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'; 

//MATERIAL
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
//

//COMPONENT
import { AppComponent } from './app.component';
import { HomeComponent } from './homeC/home/home.component';
import { NavBarComponent } from './navBar/nav-bar/nav-bar.component';
import { FooterComponent } from './footer/footer/footer.component';
import { TableComponent } from './table/table/table.component';
import { EditComponent } from './addEdit/edit/edit.component';
import { AddComponent } from './addEdit/add/add.component';
<<<<<<< HEAD
import { RegisterComponent } from './registration/register/register.component';
import { LoginComponent } from './login/login/login.component';
=======
import { ErrorComponent } from './error/error/error.component';
>>>>>>> 08aee9c6ae7c1fd5e24c8ced04608c33ed9668d5



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBarComponent,
    FooterComponent,
    TableComponent,
    EditComponent,
    AddComponent,
<<<<<<< HEAD
    RegisterComponent,
    LoginComponent
=======
    ErrorComponent,
>>>>>>> 08aee9c6ae7c1fd5e24c8ced04608c33ed9668d5
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatIconModule,
    MatMenuModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatInputModule,
    FormsModule
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
