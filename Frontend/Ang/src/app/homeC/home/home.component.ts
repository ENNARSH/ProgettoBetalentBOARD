import { Component, OnInit } from '@angular/core';
import { TableDataServiceService } from 'src/app/services/table-data-service.service';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})


export class HomeComponent implements OnInit{


  constructor(private service: TableDataServiceService){}

  ngOnInit(): void {
   this.service.loadData().subscribe();
  }

  
}
