import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { coupons } from './coupon';
import { Merchant } from './Merchant';

@Injectable({
  providedIn: 'root'
})
export class CouponServiceService {
  

  private serviceUrl="http://localhost:9099/coupons";
  private baseUrl="http://localhost:9099/merchant";

  constructor(private http: HttpClient) { }

  getCouponList(): Observable<any> {
    return this.http.get(`${this.serviceUrl}`);
  }

  // getCoupon(couponAmount: number):Observable<any> {
  //   return this.http.get(`${this.serviceUrl}/${couponAmount}`);
  // }

  // getCoupon(couponId: number):Observable<any> {
  //   return this.http.get(`${this.serviceUrl}/${couponAmount}`);
  // }

  getCouponById(couponId: number, value: any): Observable<coupons> {
    return this.http.put<coupons>(`${this.serviceUrl}/Id/${couponId}`, value);
  }

  createCoupon(coupons: Object): Observable<Object> {
    return this.http.post(`${this.serviceUrl}` + `/create`, coupons);
  }

  addNewMerchant(merchant: object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`+'/create', merchant)
  }

  getMerchantList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getMerchantForVerification(email: String):Observable<any> {
    return this.http.get(`${this.baseUrl}`+`/`+email);
  }

  getApproval(email:String, approved:boolean, value:any):Observable<any> {
    return this.http.put(`${this.baseUrl}/email/${email}/${approved}`, value)
  }
}
