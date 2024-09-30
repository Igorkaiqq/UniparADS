import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { StockListComponent } from './stock-list/stock-list.component';
import { StockService } from './stock.service';

@NgModule({
  declarations: [

  ],
  imports: [
    BrowserModule,
    AppComponent,
    StockListComponent
  ],
  providers: [StockService],
  bootstrap: []
})
export class AppModule { }
