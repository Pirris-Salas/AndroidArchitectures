package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponsInteractor
import com.anncode.offersandcoupons.model.CouponsInteractorImpl
import com.anncode.offersandcoupons.view.CouponsView

class CouponPresenterImpl(var couponsView: CouponsView): CouponPresenter {

    private var couponsInteractor: CouponsInteractor = CouponsInteractorImpl(this)

    override fun showCoupon(coupon: ArrayList<Coupon>?) {
        couponsView.showCoupons(coupon)
    }

    override fun getCoupon() {
        couponsInteractor.getCouponsAPI()
    }
}