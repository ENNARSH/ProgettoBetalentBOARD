import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import {ActivatedRoute, Router} from '@angular/router';
import { TableDataServiceService } from 'src/app/services/table-data-service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit{




  constructor(private service:TableDataServiceService, private route:ActivatedRoute , private router: Router){}
  saveCod : string = "";
  priorita :number = 0;
  prezzo :number = 0;
  tipo: string ="";
  codici:string ="";
  autoCompatibili:string= "";
  descrizione:string ="";

  ngOnInit(): void {
  this.route.paramMap.subscribe( paramMap => {
    this.saveCod = paramMap.get('codProdotto')!;
})
 this.service.getProdBycodProdotto(this.saveCod).subscribe((response) => {
  this.autoCompatibili = response.autoCompatibile
   this.priorita = response.priorita
   this.prezzo = response.prezzo
   this.tipo = response.tipo
   this.codici = response.codici
   this.descrizione = response.descrizione                                                                            





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
      prezzo: form.value.prezzo,
      priorita:form.value.priorita,
     }
/*      this.service.editData(this.saveCod,body).subscribe(response => {console.log("Prodotto modificato" + response.status)},
     error => {
      console.log
     }) */
     this.service.editData(this.saveCod,body).subscribe({
     next: (v) => console.log("Prodotto modificato :"+ v.status  + " OK")
     ,
    error: (e) => console.error("Errore : " + e.status),
     })
     this.redirectTo('/home');
    /*  this.router.navigate(['home']); */
    }

//questo metodo mi aggiorna la tabella una volta tornato in home
    redirectTo(uri: string) {
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => 
        this.router.navigate([uri]));
      }
    
}
