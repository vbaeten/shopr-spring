import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LpDetailComponent } from './lp-detail.component';

describe('LpDetailComponent', () => {
  let component: LpDetailComponent;
  let fixture: ComponentFixture<LpDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LpDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LpDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
