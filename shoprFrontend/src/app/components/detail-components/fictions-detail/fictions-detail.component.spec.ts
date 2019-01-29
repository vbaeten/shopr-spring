import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FictionsDetailComponent } from './fictions-detail.component';

describe('FictionsDetailComponent', () => {
  let component: FictionsDetailComponent;
  let fixture: ComponentFixture<FictionsDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FictionsDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FictionsDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
