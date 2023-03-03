package com.busy.looping.pitaara.retrofit

interface RetrofitResponse {
    fun onResponse(response: String?, methodName: String?, responseCode: Int)
    fun onResponseFail(methodName: String?, responseCode: Int)
}