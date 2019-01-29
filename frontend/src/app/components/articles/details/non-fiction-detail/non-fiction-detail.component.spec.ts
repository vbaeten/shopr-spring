import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NonFictionDetailComponent } from './non-fiction-detail.component';

describe('NonFictionDetailComponent', () => {
  let component: NonFictionDetailComponent;
  let fixture: ComponentFixture<NonFictionDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NonFictionDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NonFictionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
