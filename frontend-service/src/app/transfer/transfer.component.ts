import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Transfer } from "../model/transfer.model";
import { FormBuilder, FormGroup } from "@angular/forms";

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {
  transfer!: Transfer
  formTransfer!: FormGroup;

  constructor(private http: HttpClient, private fb: FormBuilder) {}

  ngOnInit(){
    this.transfer = { walletSourceId: '', walletDestinationId: '', amount: 0 }
    this.formTransfer = this.fb.group({
      walletSourceId: this.fb.control(""),
      walletDestinationId: this.fb.control(""),
      amount: this.fb.control("")
    });
  }

  handleSubmit() {
    this.transfer.amount = this.formTransfer.value.amount;
    this.transfer.walletSourceId = this.formTransfer.value.walletSourceId;
    this.transfer.walletDestinationId = this.formTransfer.value.walletDestinationId;
    console.log(this.transfer);
    this.http.post('http://localhost:8888/TRANSFER/createTransfer', this.transfer).subscribe({
      next: data => {
        alert("Transfer has been successfully completed!");
        this.formTransfer.reset();
      },
      error: err => {
        console.log(err);
      }
    });
  }
}
