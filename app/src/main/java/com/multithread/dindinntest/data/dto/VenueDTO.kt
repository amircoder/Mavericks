package com.multithread.dindinntest.data.dto


import com.google.gson.annotations.SerializedName

data class VenueDTO(
        @SerializedName("categories")
        var categories: List<Category>,
        @SerializedName("coverImages")
        var coverImages: List<String>,
        @SerializedName("id")
        var id: String,
        @SerializedName("logoUrl")
        var logoUrl: String,
        @SerializedName("name")
        var name: Name
) {
    data class Category(
            @SerializedName("id")
            var id: String,
            @SerializedName("name")
            var name: String,
            @SerializedName("products")
            var products: List<Product>
    )

    data class Product(
            @SerializedName("description")
            var description: String,
            @SerializedName("id")
            var id: String,
            @SerializedName("imageUrl")
            var imageUrl: String,
            @SerializedName("info")
            var info: String,
            @SerializedName("price")
            var price: Price,
            @SerializedName("title")
            var title: String
    )

    data class Price(
            @SerializedName("total")
            var total: Double,
            @SerializedName("unit")
            var unit: String
    )

    data class Name(
            @SerializedName("first")
            var first: String,
            @SerializedName("last")
            var last: String
    )
}