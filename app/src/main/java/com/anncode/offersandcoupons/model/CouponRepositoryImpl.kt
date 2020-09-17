package com.anncode.offersandcoupons.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl: CouponRepository {

    private var coupons = MutableLiveData<List<Coupon>>()
    //Subject MutableLiveData
    //Observers List Coupon
    //Change List Coupon- MutableLiveData
    //Observe


    //Toda la lógica de la conexión
    override fun callCouponsAPI() {

        //CONTROLLER
        var couponList: ArrayList<Coupon>? = ArrayList<Coupon>()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message)
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    couponList?.add(coupon)
                }
                //VIEW

                coupons.value = couponList
            }

        })
        //CONTROLLER

    }

    override fun getCoupuns(): MutableLiveData<List<Coupon>> {
        return coupons
    }
}