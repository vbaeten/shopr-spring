import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FictionsOverviewComponent } from './fictions-overview.component';

describe('FictionsOverviewComponent', () => {
  let component: FictionsOverviewComponent;
  let fixture: ComponentFixture<FictionsOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FictionsOverviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FictionsOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
