import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';

import { ProductComponent } from './product.component';
import {ProductService} from "../services/product.service";
import { ActivatedRoute } from '@angular/router';

 // Import FormsModule

describe('ProductComponent', () => {
  let component: ProductComponent;
  let fixture: ComponentFixture<ProductComponent>;

  beforeEach(() => {
  TestBed.configureTestingModule({
    declarations: [ProductComponent],
    imports: [HttpClientTestingModule],
    providers: [
      ProductService,
      { provide: ActivatedRoute, useValue: { snapshot: { paramMap: new Map() } }
      }
    ]
  });
});

    fixture = TestBed.createComponent(ProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

 it('should create', () => {
  const fixture = TestBed.createComponent(ProductComponent);
  const component = fixture.componentInstance;
  expect(component).toBeTruthy();
});

});
