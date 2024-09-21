import { Component } from '@angular/core';

@Component({
  selector: 'app-movimentacao-overlay',
  templateUrl: './movimentacao-overlay.component.html',
  styleUrls: ['./movimentacao-overlay.component.css']
})
export class MovimentacaoOverlayComponent {
  isVisible = false;

  openOverlay() {
    this.isVisible = true;
  }

  closeOverlay() {
    this.isVisible = false;
  }
}