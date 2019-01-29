import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LpsDetailComponent } from './lps-detail.component';

describe('LpsDetailComponent', () => {
  let component: LpsDetailComponent;
  let fixture: ComponentFixture<LpsDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LpsDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LpsDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
