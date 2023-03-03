package com.busy.looping.pitaara.models

import com.google.gson.annotations.SerializedName

data class SingleCategory(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("rating")
	val rating: Any? = null,

	@field:SerializedName("avlSize")
	val avlSize: String? = null,

	@field:SerializedName("mrp")
	val mrp: Any? = null,

	@field:SerializedName("genderSp")
	val genderSp: String? = null,

	@field:SerializedName("ratingCount")
	val ratingCount: Int? = null,

	@field:SerializedName("no_items")
	val noItems: Any? = null,

	@field:SerializedName("tags")
	val tags: List<String?>? = null,

	@field:SerializedName("des")
	val des: String? = null,

	@field:SerializedName("price")
	val price: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("category")
	val category: String? = null
)
