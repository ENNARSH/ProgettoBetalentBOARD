import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import {  HttpParams } from '@angular/common/http';
import { TableDataServiceService } from 'src/app/services/table-data-service.service';
import { Route, Router } from '@angular/router';
import { Prodotti } from 'src/app/interface/Prodotti';

@Component({
  selector: 'app-preventivo',
  templateUrl: './preventivo.component.html',
  styleUrls: ['./preventivo.component.css']
})
export class PreventivoComponent {

  prod :Prodotti[] = [];
  isEmpty:boolean = true;

constructor(private service:TableDataServiceService,private router:Router){}

  onSubmit(form : NgForm){
    const tipo: string = form.value.tipo;
    const autoCompatibile:string =  form.value.autoCompatibile;
    const budget:number = form.value.budget; 
    this.service.prevData(tipo,autoCompatibile,budget).subscribe((response) => this.prod=response)
 /*    this.service.prevData(autoCompatibile,budget).subscribe((response) => this.prod=response) */
    this.isEmpty= false;
    
 
   }
}
