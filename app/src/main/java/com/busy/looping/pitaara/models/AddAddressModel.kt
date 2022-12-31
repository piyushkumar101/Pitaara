package com.busy.looping.pitaara.models

import com.google.gson.annotations.SerializedName

data class AddAddressModel(

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("pinCode")
	val pinCode: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mobile")
	val mobile: String? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("userId")
	val userId: String? = null
)
