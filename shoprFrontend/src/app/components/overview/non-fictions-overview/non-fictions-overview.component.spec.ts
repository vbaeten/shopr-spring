import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NonFictionsOverviewComponent } from './non-fictions-overview.component';

describe('NonFictionsOverviewComponent', () => {
  let component: NonFictionsOverviewComponent;
  let fixture: ComponentFixture<NonFictionsOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NonFictionsOverviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NonFictionsOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
