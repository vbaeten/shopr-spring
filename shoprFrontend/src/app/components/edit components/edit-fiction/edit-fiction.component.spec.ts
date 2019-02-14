import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditFictionComponent } from './edit-fiction.component';

describe('EditFictionComponent', () => {
  let component: EditFictionComponent;
  let fixture: ComponentFixture<EditFictionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditFictionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditFictionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
