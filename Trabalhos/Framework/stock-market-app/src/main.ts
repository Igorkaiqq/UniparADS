import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter, Routes } from '@angular/router';
import { AppComponent } from './app/app.component';
import { StockListComponent } from './app/stock-list/stock-list.component';
import { StockService } from './app/stock.service';

const routes: Routes = [
  { path: '', component: StockListComponent },
];

bootstrapApplication(AppComponent, {
  providers: [
    StockService,
    provideRouter(routes)
  ],
}).catch(err => console.error(err));
