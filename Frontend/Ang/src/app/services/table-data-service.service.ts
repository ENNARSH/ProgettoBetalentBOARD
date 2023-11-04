import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Prodotti } from 'app/interface/Prodotti';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TableDataServiceService implements OnInit{

  constructor(private http:HttpClient) { }
 
  server : string = "localhost";
  port : string = "8080";
 
 
  ngOnInit(): void {
       this.loadData();
  }
  
  loadData(){
        return this.http.get<Prodotti[]>(`http://${this.server}:${this.port}/rest/prodotti`);
  }  
  

  delProdByCodProd = (codProdotto:string) =>

    this.http.delete<string>(`http://${this.server}:${this.port}/rest/prodotti/${codProdotto}`);
  

  addData(body: Prodotti){
    return this.http.post(`http://${this.server}:${this.port}/rest/prodotti`, body,{responseType: 'text'});
  }
  
  editData(codProdotto:string , body:Prodotti){
    return this.http.put(`http://${this.server}:${this.port}/rest/prodotti/${codProdotto}`,body,{observe:'response'});
  }
  
}
