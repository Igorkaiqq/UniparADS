import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovimentacaoOverlayComponent } from './movimentacao-overlay.component';

describe('MovimentacaoOverlayComponent', () => {
  let component: MovimentacaoOverlayComponent;
  let fixture: ComponentFixture<MovimentacaoOverlayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MovimentacaoOverlayComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MovimentacaoOverlayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
