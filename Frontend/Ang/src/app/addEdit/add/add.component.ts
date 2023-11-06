import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { TableDataServiceService } from 'src/app/services/table-data-service.service';


@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent {
/* @ViewChild('addform') addform : NgForm | undefined */

constructor(private service:TableDataServiceService){}


/*   onSubmit(form : NgForm){} */
  onSubmit(form : NgForm){
   let body = {
    idProdotto: 0,
    codProdotto: form.value.codProdotto,
    tipo: form.value.tipo,
    codici: form.value.codici,
    autoCompatibile: form.value.autoCompatibile,
    descrizione: form.value.descrizione,
    prezzo: form.value.prezzo,
    priorita: form.value.priorita,
   }
   this.service.addData(body).subscribe((response) => console.log(response))
  }
}
