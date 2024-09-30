import { Injectable } from '@angular/core';
import { BehaviorSubject, interval } from 'rxjs';
import { map } from 'rxjs/operators';

export interface Stock {
  simbolo: string;
  nomeEmpresa: string;
  preco: number;
  previousPrice: number;
  isRising: boolean;
  changePercent: number;
}

@Injectable({
  providedIn: 'root'
})
export class StockService {
  private stocks: Stock[] = [];
  private funds: Stock[] = [];
  private stocksSubject = new BehaviorSubject<Stock[]>([]);
  private fundsSubject = new BehaviorSubject<Stock[]>([]);

  constructor() {
    this.initializeStocks();
    this.updatePrices();
  }

  private initializeStocks() {

    const stockData = [
      { simbolo: 'VALE3', nomeEmpresa: 'Vale S.A.' },
      { simbolo: 'PETR4', nomeEmpresa: 'Petrobras' },
      { simbolo: 'ITUB4', nomeEmpresa: 'Itaú Unibanco' },
      { simbolo: 'BBDC4', nomeEmpresa: 'Bradesco' },
      { simbolo: 'BBAS3', nomeEmpresa: 'Banco do Brasil' },
      { simbolo: 'WEGE3', nomeEmpresa: 'WEG S.A.' },
      { simbolo: 'ABEV3', nomeEmpresa: 'Ambev' },
      { simbolo: 'EGIE3', nomeEmpresa: 'Engie Brasil' },
      { simbolo: 'GGBR4', nomeEmpresa: 'Gerdau' },
      { simbolo: 'SUZB3', nomeEmpresa: 'Suzano' }
    ];


    const fundData = [
      { simbolo: 'KNRI11', nomeEmpresa: 'Kinea Renda Imobiliária' },
      { simbolo: 'HGLG11', nomeEmpresa: 'CSHG Logística' },
      { simbolo: 'XPML11', nomeEmpresa: 'XP Malls' },
      { simbolo: 'VISC11', nomeEmpresa: 'Vinci Shopping Centers' },
      { simbolo: 'HGBS11', nomeEmpresa: 'Hedge Brasil Shopping' },
      { simbolo: 'XPLG11', nomeEmpresa: 'XP Logística' },
      { simbolo: 'IRDM11', nomeEmpresa: 'Iridium Recebíveis' },
      { simbolo: 'RBRP11', nomeEmpresa: 'RBR Properties' },
      { simbolo: 'BCFF11', nomeEmpresa: 'BTG Pactual Fundo de Fundos' },
      { simbolo: 'MXRF11', nomeEmpresa: 'Maxi Renda' }
    ];

    stockData.forEach(data => {
      this.stocks.push({
        simbolo: data.simbolo,
        nomeEmpresa: data.nomeEmpresa,
        preco: this.getRandomPrice(),
        previousPrice: 0,
        isRising: true,
        changePercent: 0
      });
    });

    fundData.forEach(data => {
      this.funds.push({
        simbolo: data.simbolo,
        nomeEmpresa: data.nomeEmpresa,
        preco: this.getRandomPrice(),
        previousPrice: 0,
        isRising: true,
        changePercent: 0
      });
    });

    this.stocksSubject.next(this.stocks);
    this.fundsSubject.next(this.funds);
  }

  private getRandomPrice(): number {
    return Math.round(Math.random() * 1000) / 100;
  }

  private updatePrices() {
    interval(2000).pipe(
      map(() => {
        this.stocks.forEach(stock => {
          stock.previousPrice = stock.preco;
          const newPrice = this.getRandomPrice();
          stock.isRising = newPrice >= stock.previousPrice;
          stock.preco = newPrice;

          const priceDifference = stock.preco - stock.previousPrice;
          stock.changePercent = (priceDifference / stock.previousPrice) * 100;
        });

        this.funds.forEach(fund => {
          fund.previousPrice = fund.preco;
          const newPrice = this.getRandomPrice();
          fund.isRising = newPrice >= fund.previousPrice;
          fund.preco = newPrice;

          const priceDifference = fund.preco - fund.previousPrice;
          fund.changePercent = (priceDifference / fund.previousPrice) * 100;
        });

        this.stocksSubject.next(this.stocks);
        this.fundsSubject.next(this.funds);
      })
    ).subscribe();
  }


  getStocks() {
    return this.stocksSubject.asObservable();
  }

  getFunds() {
    return this.fundsSubject.asObservable();
  }
}
