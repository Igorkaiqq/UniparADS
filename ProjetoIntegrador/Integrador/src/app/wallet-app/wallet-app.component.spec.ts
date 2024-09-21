import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WalletAppComponent } from './wallet-app.component';

describe('WalletAppComponent', () => {
  let component: WalletAppComponent;
  let fixture: ComponentFixture<WalletAppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WalletAppComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WalletAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
