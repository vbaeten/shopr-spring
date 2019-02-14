import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditNonFictionComponent } from './edit-non-fiction.component';

describe('EditNonFictionComponent', () => {
  let component: EditNonFictionComponent;
  let fixture: ComponentFixture<EditNonFictionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditNonFictionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditNonFictionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
