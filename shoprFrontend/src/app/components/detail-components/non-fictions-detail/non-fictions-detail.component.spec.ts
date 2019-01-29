import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NonFictionsDetailComponent } from './non-fictions-detail.component';

describe('NonFictionsDetailComponent', () => {
  let component: NonFictionsDetailComponent;
  let fixture: ComponentFixture<NonFictionsDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NonFictionsDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NonFictionsDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
