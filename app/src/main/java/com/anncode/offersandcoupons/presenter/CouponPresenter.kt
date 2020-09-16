package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon

interface CouponPresenter {
    //Vista
    fun showCoupon(coupon: ArrayList<Coupon>?)

    //Interactor
    fun getCoupon()
}