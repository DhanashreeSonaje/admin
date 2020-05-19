import { TestBed, inject } from '@angular/core/testing';

import { CouponServiceService } from './coupon-service.service';

describe('CouponServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CouponServiceService]
    });
  });

  it('should be created', inject([CouponServiceService], (service: CouponServiceService) => {
    expect(service).toBeTruthy();
  }));
});
