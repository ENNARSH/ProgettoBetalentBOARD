import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { Prodotti } from 'src/app/interface/Prodotti';
import { Observable, map, of } from 'rxjs';
import { TableDataServiceService } from 'src/app/services/table-data-service.service';
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit,OnChanges{

  prod : Prodotti[] = [];
  prodF!: Prodotti;
  error : string = "Errore!!!"
 codProdotto : string = "";
 isPresent : boolean = false;
 filtro:string ="";

  constructor(private service:TableDataServiceService, private router: Router){}
    

  ngOnChanges(changes: SimpleChanges): void {
   /*  this.loadMethod(); */
   this.loadMethod();
  }

  ngOnInit(): void {
   this.loadMethod();
  }
  

  refresh = (event : any) => {
    console.log(this.filtro)
    this.filtro = event.target.value;
   this.service.getProdBycodProdotto(this.filtro).subscribe({
    next: (response) => {this.prodF = response; this.isPresent = true;} , 
    error: (error) => {console.error(error);
                   this.isPresent = false;}})
   
   
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

Aggiungi(){
  this.router.navigate(['add']);
}






}
