package com.anncode.offersandcoupons.view

import com.anncode.offersandcoupons.model.Coupon

interface CouponsView {
    //Vista
    fun showCoupons(coupons: ArrayList<Coupon>?)

    //Presenter
    fun getCoupons()
}