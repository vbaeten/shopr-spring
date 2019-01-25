import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFictionComponent } from './add-fiction.component';

describe('AddFictionComponent', () => {
  let component: AddFictionComponent;
  let fixture: ComponentFixture<AddFictionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddFictionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFictionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
