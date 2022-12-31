package com.busy.looping.pitaara.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.busy.looping.pitaara.baseactivity.BaseActivity
import com.busy.looping.pitaara.databinding.ActivityAddaddressActivtiyBinding
import com.busy.looping.pitaara.gobal.Constance
import com.busy.looping.pitaara.models.AddAddressModel
import com.busy.looping.pitaara.models.SingleCategory
import com.busy.looping.pitaara.retrofit.RetrofitResponse
import com.busy.looping.pitaara.retrofit.URL
import com.google.gson.Gson
import com.google.gson.JsonObject


class AddaddressActivtiy : BaseActivity() {
  lateinit  var binding :ActivityAddaddressActivtiyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddaddressActivtiyBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.removeBtn.setOnClickListener {
           if(Validation())
           {
               var addressModel=AddAddressModel(address = binding.tvHousenumber.text.toString()+binding.tvTown.text.toString(),
               pinCode = binding.tvPincode.text.toString(), city = binding.tvCity.text.toString(),
             name = binding.tvName.text.toString(), mobile = binding.tvName.text.toString(), state = binding.tvState.text.toString(),
               userId = "11")
               var body=Gson().toJson(addressModel)
               var json= JsonObject()
               json.addProperty("userId","11")
               json.addProperty("name",binding.tvName.text.toString())
               json.addProperty("mobile",binding.tvMobileNumber.text.toString())
               json.addProperty("address",binding.tvHousenumber.text.toString()+binding.tvTown.text.toString())
               json.addProperty("city",binding.tvCity.text.toString())
               json.addProperty("state",binding.tvState.text.toString())
               json.addProperty("pinCode",binding.tvPincode.text.toString())


               callWb(this,
                   Constance.BASE_URL+ URL.ADD_USERADDRESS,
                   Constance.POST,json,object : RetrofitResponse {
                   override fun onResponse(response: String?, methodName: String?, responseCode: Int) {
                     Log.d("ResponseCode",responseCode.toString())

                   }

                   override fun onResponseFail(methodName: String?, responseCode: Int) {
                       Log.d("ResponseCode",methodName.toString())
                   }

               })

           }
       }
    }
    fun Validation():Boolean
    {
        if(binding.tvName.text.isEmpty() && binding.tvMobileNumber.text.isEmpty()&&binding.tvState.text.isEmpty()
            &&binding.tvPincode.text.isEmpty()&&binding.tvTown.text.isEmpty()&&binding.tvHousenumber.text.isEmpty()
            &&binding.tvCity.text.isEmpty())
        {
            Toast.makeText(this,"Please Enter All details",Toast.LENGTH_SHORT).show()
            return false;

        }
        return true
    }

}