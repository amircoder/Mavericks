package com.multithread.dindinntest.data.dto


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PriceDTO(
    @SerializedName("total")
    val total: Int,
    @SerializedName("unit")
    val unit: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(total)
        parcel.writeString(unit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PriceDTO> {
        override fun createFromParcel(parcel: Parcel): PriceDTO {
            return PriceDTO(parcel)
        }

        override fun newArray(size: Int): Array<PriceDTO?> {
            return arrayOfNulls(size)
        }
    }
}