import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Prodotti } from 'app/interface/Prodotti';

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
  
}
