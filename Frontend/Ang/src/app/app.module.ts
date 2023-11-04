import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

//COMPONENT
import { AppComponent } from './app.component';
import { HomeComponent } from './homeC/home/home.component';
import { NavBarComponent } from './navBar/nav-bar/nav-bar.component';
//MATERIAL
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FooterComponent } from './footer/footer/footer.component';
import { TableComponent } from './table/table/table.component';
import { EditComponent } from './addEdit/edit/edit.component';
import { AddComponent } from './addEdit/add/add.component';


//

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBarComponent,
    FooterComponent,
    TableComponent,
    EditComponent,
    AddComponent,
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
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
