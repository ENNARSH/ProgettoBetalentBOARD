import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { TableDataServiceService } from 'app/services/table-data-service.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit{

 
  

  constructor(private service:TableDataServiceService, private router:ActivatedRoute){}
  saveCod : string = "";
  
  ngOnInit(): void {
  this.router.paramMap.subscribe( paramMap => {
    this.saveCod = paramMap.get('codProdotto')!;
})  
  }

    onSubmit(form : NgForm){
     let body = {
      idProdotto: null,
      codProdotto: this.saveCod,
      tipo: form.value.tipo,
      codici: form.value.codici,
      autoCompatibile: form.value.autoCompatibile,
      descrizione: form.value.descrizione,
      prezzo: form.value.prezzo
     }
/*      this.service.editData(this.saveCod,body).subscribe(response => {console.log("Prodotto modificato" + response.status)},
     error => {
      console.log
     }) */
     this.service.editData(this.saveCod,body).subscribe({
     next: (v) => console.log("Prodotto modificato :"+ v.status  + " OK"),
    error: (e) => console.error("Errore : " + e.status),
     })
    }
}
