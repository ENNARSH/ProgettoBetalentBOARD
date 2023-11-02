import { Component, OnInit } from '@angular/core';
import { Prodotti } from 'app/interface/Prodotti';
import { TableDataServiceService } from 'app/services/table-data-service.service';
import { map } from 'rxjs';
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit{
  prodotti: Prodotti[]  = [
    {idProdotto: 1 , codProdotto: 'Test' , tipo : 'testiamo' , codici : 'AB45CD34' , autoCompatibile : 'nissan' , descrizione : 'auto bella' , prezzo : 15},
    {idProdotto: 2 , codProdotto: 'Test2' , tipo : 'testiamo2' , codici : 'AB45CD3422' , autoCompatibile : 'nissan2' , descrizione : 'auto bella2' , prezzo : 152},
  ]
  prod : Prodotti[] = [];
  error : string = "Errore!!!"
  constructor(private service:TableDataServiceService){}
  ngOnInit(): void {
   
    //api call with error
 this.service.loadData().subscribe({
  next: this.handleResponse.bind(this),
  error:this.handleError.bind(this)
 });

  }

  handleResponse(response: Prodotti[]){
    this.prod = response;
  }
  
  handleError(error:Object){
    this.error = error.toString();
  }

  //simple api call
  /*
this.service.loadData().subscribe((data) => {
  this.prod = data;
})*/
}
