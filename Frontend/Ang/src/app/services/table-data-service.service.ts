import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Prodotti } from 'src/app/interface/Prodotti';


@Injectable({
  providedIn: 'root'
})
export class TableDataServiceService implements OnInit{

  constructor(private http:HttpClient,private router:Router) { }
 
  server : string = "localhost";
  port : string = "8080";
 prod: Prodotti[] = [];
 
  ngOnInit(): void {
   
  }
  
  loadData(){
    /* let headers = new HttpHeaders(
      {Authorization: 'Basic' + window.btoa(user + ":" + password)}
    ) */
        return this.http.get<Prodotti[]>(`http://${this.server}:${this.port}/rest/prodotti`/*  {headers} */);
  }  

  getProdBycodProdotto(codProdotto:string){
    /* let headers = new HttpHeaders(
      {Authorization: 'Basic' + window.btoa(user + ":" + password)}
    ) */
        return this.http.get<Prodotti>(`http://${this.server}:${this.port}/rest/prodotti/trovapercod/${codProdotto}`);
  }  
  

  delProdByCodProd = (codProdotto:string) =>

    this.http.delete<string>(`http://${this.server}:${this.port}/rest/prodotti/${codProdotto}`);
  

  addData(body: Prodotti){
    return this.http.post(`http://${this.server}:${this.port}/rest/prodotti`, body,{responseType: 'text'});
  }
  
  editData(codProdotto:string , body:Prodotti){
    return this.http.put(`http://${this.server}:${this.port}/rest/prodotti/${codProdotto}`,body,{observe:'response'});
  }

/*   prevData(autoCompatibile:string,budget:number){
    return this.http.get<Prodotti[]>(`http://${this.server}:${this.port}/rest/prodotti/${autoCompatibile}/${budget}`)

  } */

  prevData(/* params:HttpParams */tipo:string,autoCompatibile:string,budget:number){
    return this.http.get<Prodotti[]>(`http://${this.server}:${this.port}/rest/prodotti/${tipo}/${autoCompatibile}/${budget}`)

  }
  
   
}
  

