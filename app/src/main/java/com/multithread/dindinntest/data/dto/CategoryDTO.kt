package com.multithread.dindinntest.data.dto


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CategoryDTO(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("products")
    val products: List<ProductDTO> = emptyList()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString()?: "",
        parcel.createTypedArrayList(ProductDTO) ?: emptyList()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeTypedList(products)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CategoryDTO> {
        override fun createFromParcel(parcel: Parcel): CategoryDTO {
            return CategoryDTO(parcel)
        }

        override fun newArray(size: Int): Array<CategoryDTO?> {
            return arrayOfNulls(size)
        }
    }
}