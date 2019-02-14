import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditLpsComponent } from './edit-lps.component';

describe('EditLpsComponent', () => {
  let component: EditLpsComponent;
  let fixture: ComponentFixture<EditLpsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditLpsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditLpsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
