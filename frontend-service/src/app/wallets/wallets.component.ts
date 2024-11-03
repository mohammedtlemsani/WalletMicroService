import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-wallets',
  templateUrl: './wallets.component.html',
  styleUrl: './wallets.component.css'
})
export class WalletsComponent implements OnInit{
  wallets: any;
  constructor(private http:HttpClient) {}

  ngOnInit() {
  this.http.get('http://localhost:8888/SERVICE-WALLET/wallets/').subscribe(
    data => {
      this.wallets = data;
  },
    error => {
      console.log(error);
    }
  )
  }
}
