import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
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
 codProdotto : string = "";

  constructor(private service:TableDataServiceService, private router: Router){}

  ngOnInit(): void {
   
   this.loadMethod();

  }

  //api call with error (get)
  loadMethod(){
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
  //

  //simple api call
  /*
this.service.loadData().subscribe((data) => {
  this.prod = data;
})*/

//


//delete call method 
Elimina(codProdotto: string){
  this.codProdotto = codProdotto;
  this.service.delProdByCodProd(codProdotto).subscribe({
    next: this.handleOkDelete.bind(this),
    error: this.handleErrDelete.bind(this)
  });
  }
  handleOkDelete(response: any) {
    this.prod = this.prod.filter(item => item.codProdotto !== this.codProdotto);
    this.codProdotto = "";

  }

  handleErrDelete(error: any) {
    console.log(error);
    this.error = error.error.message;
  }

//






//edit call method
Modifica(codProdotto:string){

  this.router.navigate(['edit',codProdotto]);
}

Aggiungi(){}

}
