import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule,FormBuilder} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import { CouponServiceService } from './coupon-service.service';
import { CouponCreationComponent } from './coupon-creation/coupon-creation.component';
import { AllCouponsComponent } from './all-coupons/all-coupons.component';
import { ShowCouponComponent } from './show-coupon/show-coupon.component';
import { EmailCheckComponent } from './email-check/email-check.component';
import { AddMerchantComponent } from './add-merchant/add-merchant.component';
import { ShowMerchantComponent } from './show-merchant/show-merchant.component';;
import { VerifyMerchantComponent } from './verify-merchant/verify-merchant.component'
@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule,
        AppRoutingModule
        
    ],
    declarations: [
        AppComponent,
       CouponCreationComponent,
       AllCouponsComponent ,
       ShowCouponComponent ,
       EmailCheckComponent ,
       AddMerchantComponent ,
       ShowMerchantComponent ,
       VerifyMerchantComponent  	],
    providers: [CouponServiceService],
    bootstrap: [AppComponent]
})

export class AppModule { }


