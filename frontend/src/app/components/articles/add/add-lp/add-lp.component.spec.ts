import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLpComponent } from './add-lp.component';

describe('AddLpComponent', () => {
  let component: AddLpComponent;
  let fixture: ComponentFixture<AddLpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddLpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddLpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
