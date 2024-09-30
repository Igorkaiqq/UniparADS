import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { StockListComponent } from './stock-list/stock-list.component';
import {Observable} from "rxjs";
import {Stock, StockService} from "./stock.service";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, StockListComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  selectedStock: any = null;
  selectedStockData: any[] = [];
  selectedStockName: string = '';

  stocks$: Observable<Stock[]>;

  constructor(private stockService: StockService) {
    this.stocks$ = this.stockService.getStocks();
  }

  openChart(stock: Stock): void {
    this.selectedStock = stock;
    this.selectedStockName = stock.nomeEmpresa;
    // Exemplo de dados de variação de preço ao longo do tempo
    this.selectedStockData = [stock.previousPrice, 2.8, 3.2, 3.5, stock.preco];
  }
}
