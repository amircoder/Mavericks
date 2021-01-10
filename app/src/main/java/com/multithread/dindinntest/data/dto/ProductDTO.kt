package com.multithread.dindinntest.data.dto


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ProductDTO(
        @SerializedName("description")
    val description: String,
        @SerializedName("id")
    val id: String,
        @SerializedName("imageUrl")
    val imageUrl: String,
        @SerializedName("info")
    val info: String,
        @SerializedName("price")
    val price: PriceDTO,
        @SerializedName("title")
    val title: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readParcelable(PriceDTO::class.java.classLoader) ?: PriceDTO(0, "usd"),
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeString(id)
        parcel.writeString(imageUrl)
        parcel.writeString(info)
        parcel.writeParcelable(price, flags)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductDTO> {
        override fun createFromParcel(parcel: Parcel): ProductDTO {
            return ProductDTO(parcel)
        }

        override fun newArray(size: Int): Array<ProductDTO?> {
            return arrayOfNulls(size)
        }
    }
}