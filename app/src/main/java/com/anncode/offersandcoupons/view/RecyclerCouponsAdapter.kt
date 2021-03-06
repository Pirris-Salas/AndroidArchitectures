package com.anncode.offersandcoupons.view

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.anncode.offersandcoupons.BR
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.viewmodel.CouponViewModel
import com.squareup.picasso.Picasso

class RecyclerCouponsAdapter(var couponViewModel: CouponViewModel, var resource: Int) : RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>() {

    var coupons : List<Coupon>? = null

    fun setCouponsList(coupons: List<Coupon>){
        this.coupons = coupons
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardCouponHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
        var binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, viewGroup, false)

        return CardCouponHolder(binding)
    }

    override fun getItemCount(): Int {
        return coupons?.size ?: 0
    }

    override fun onBindViewHolder(cardCouponHolder: CardCouponHolder, position: Int) {
        cardCouponHolder.setDataCard(couponViewModel, position)
        cardCouponHolder.itemView.setOnClickListener {
            Log.w("COUPON PO", position.toString())
            val context = cardCouponHolder.itemView.context
            val showPhotoIntent = Intent(context, CouponDetailActivity::class.java)
            showPhotoIntent.putExtra("COUPON", coupons?.get(position))
            context.startActivity(showPhotoIntent)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int): Int{
        return resource
    }

    class CardCouponHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun setDataCard(couponViewModel: CouponViewModel, position: Int){
            binding?.setVariable(BR.model, couponViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }


    }

}
