import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { StockService, Stock } from '../stock.service';
import {AsyncPipe, CommonModule, CurrencyPipe, NgClass} from "@angular/common";

@Component({
  selector: 'app-stock-list',
  templateUrl: './stock-list.component.html',
  standalone: true,
  imports: [
    CurrencyPipe,
    AsyncPipe,
    NgClass,
    CommonModule
  ],
  styleUrls: ['./stock-list.component.css']
})
export class StockListComponent implements OnInit {
  stocks$!: Observable<Stock[]>;
  funds$!: Observable<Stock[]>;

  constructor(private stockService: StockService) {}

  ngOnInit(): void {
    this.stocks$ = this.stockService.getStocks();
    this.funds$ = this.stockService.getFunds();
  }
}
