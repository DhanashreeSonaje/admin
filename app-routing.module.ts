import {NgModule} from '@angular/core';
import {Routes,RouterModule} from '@angular/router';
import { CouponCreationComponent } from './coupon-creation/coupon-creation.component';
import { AllCouponsComponent } from './all-coupons/all-coupons.component';
import { ShowCouponComponent } from './show-coupon/show-coupon.component';
import { AddMerchantComponent } from './add-merchant/add-merchant.component';
import { ShowMerchantComponent } from './show-merchant/show-merchant.component';
import { EmailCheckComponent } from './email-check/email-check.component';
import { VerifyMerchantComponent } from './verify-merchant/verify-merchant.component';

const routes:Routes=[
    {path:'addCoupon',component:CouponCreationComponent},
    {path:'showCouponsForAdmin',component:AllCouponsComponent},
    {path:'showCouponsForCustomer',component:ShowCouponComponent},
    {path:'addMerchant',component:AddMerchantComponent},
    {path:'showMerchant',component:ShowMerchantComponent},
    {path:'regMerchant',component:EmailCheckComponent},
    {path:'verifyMerchant/:email',component:VerifyMerchantComponent}
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports:[RouterModule]
})
export class AppRoutingModule{}

