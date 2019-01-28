import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllItemsOverviewComponent } from './all-items-overview.component';

describe('AllItemsOverviewComponent', () => {
  let component: AllItemsOverviewComponent;
  let fixture: ComponentFixture<AllItemsOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllItemsOverviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllItemsOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
