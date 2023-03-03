package com.busy.looping.pitaara.retrofit

import com.busy.looping.pitaara.gobal.Constance
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit

import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*
import java.util.HashMap

object RetrofitClient {
    val retroFitClient: getService
        get() {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(Constance.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
            return retrofit.create(getService::class.java)
        }


    interface getService {
        @POST
        fun getPostService(
            @HeaderMap headers: HashMap<String?, String?>?,
            @Url url: String?,
            @Body parmas: String?
        ): Call<String?>?

        @GET
        fun getGETService(
            @HeaderMap headers: HashMap<String?, String?>?,
            @Url url: String?,
            @QueryMap queryParams: HashMap<String, Any>
        ): Call<String?>?

        @DELETE
        fun getDeleteService(
            @HeaderMap headers: HashMap<String?, String?>?,
            @Url url: String?,
            @QueryMap queryParams: HashMap<String?, Any?>?
        ): Call<String?>?

        @PUT
        fun getPutService(
            @HeaderMap headers: HashMap<String?, String?>?,
            @Url url: String?,
            @Body parmas: String?
        ): Call<String?>?

        @PATCH
        fun getPatchService(
            @HeaderMap headers: HashMap<String?, String?>?,
            @Url url: String?,
            @Body parmas: String?
        ): Call<String?>?

        @Multipart
        @POST
        fun requestWithFile(
            @HeaderMap headers: HashMap<String?, String?>?,
            @Url url: String?,
            @PartMap parts: Map<String?, String?>?,
            @Part file: MultipartBody.Part?
        ): Call<String?>?

        @Multipart
        @POST
        fun requestWithFiles(
            @HeaderMap headers: HashMap<String?, String?>?,
            @Url url: String?,
            @PartMap parts: Map<String?, String?>?,
            @Part files: List<MultipartBody.Part?>?
        ): Call<String?>?

        @Multipart
        @PUT
        fun requestWithFilesPut(
            @HeaderMap headers: HashMap<String?, String?>?,
            @Url url: String?,
            @PartMap parts: Map<String?, String?>?,
            @Part files: List<MultipartBody.Part?>?
        ): Call<String?>?
    }
}




