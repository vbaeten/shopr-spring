import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LpsOverviewComponent } from './lps-overview.component';

describe('LpsOverviewComponent', () => {
  let component: LpsOverviewComponent;
  let fixture: ComponentFixture<LpsOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LpsOverviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LpsOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
