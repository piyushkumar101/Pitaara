package com.busy.looping.pitaara.baseactivity

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.busy.looping.pitaara.gobal.Constance
import com.busy.looping.pitaara.models.SingleCategory
import com.busy.looping.pitaara.retrofit.*
import com.busy.looping.pitaara.retrofit.RetrofitClient.retroFitClient
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.util.HashMap

open class BaseActivity:AppCompatActivity() {

    fun callWb(
        context: Context?,
        url: String,
        mainMethodType: String?,
        params: JsonObject,
        retrofitResponse: RetrofitResponse
    ) {
        callWbs(
            context, url, mainMethodType, params,
            loaderShow = true,
            isCancelable = false,
            retrofitResponse = retrofitResponse,
            file = null
        )

    }

    fun callWbs(
        context: Context?,
        url: String,
        mainMethodType: String?,
        params: JsonObject,
        loaderShow: Boolean,
        isCancelable: Boolean,
        retrofitResponse: RetrofitResponse,
        file: File?
    ) {
        val headers = HashMap<String?, String?>()
        var call: Call<String?>? = null

        when (mainMethodType) {
            Constance.POST -> {
               Log.d("PARMS=====",params.toString())
                call = retroFitClient.getPostService(
                    headers,
                    Constance.BASE_URL,
                    params.toString()
                )
            }
            Constance.GET -> {
                headers["Content-Type"] = "application/json"
               var map=HashMap<String, Any>()
                call = retroFitClient.getGETService(headers, url, map)
            }

        }
          call?.enqueue(object :Callback<String?>{
              override fun onResponse(call: Call<String?>, response: Response<String?>) {

                  Log.d("API==++++",response.body().toString())
                  Toast.makeText(context,response.body().toString(),Toast.LENGTH_SHORT).show()
                  retrofitResponse.onResponse(response.body().toString(), " ", response.code());
              }

              override fun onFailure(call: Call<String?>, t: Throwable) {
                 // Toast.makeText(context,call.toString(),Toast.LENGTH_SHORT).show()
                  Log.d("Error",t.toString())
                  Log.d("API==++++",t.toString())
                  retrofitResponse.onResponseFail("methodName", 401)
              }

          })
    }



    }

