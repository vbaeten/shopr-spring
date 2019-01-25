import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNonFictionComponent } from './add-non-fiction.component';

describe('AddNonFictionComponent', () => {
  let component: AddNonFictionComponent;
  let fixture: ComponentFixture<AddNonFictionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddNonFictionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNonFictionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
