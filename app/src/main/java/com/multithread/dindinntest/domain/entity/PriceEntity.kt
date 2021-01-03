package com.multithread.dindinntest.domain.entity

import android.os.Parcel
import android.os.Parcelable
import com.multithread.dindinntest.AppConstant

data class PriceEntity(
    val total: Double = 0.0,
    val unit: String = AppConstant.DEFAULT_UNIT
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(total)
        parcel.writeString(unit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PriceEntity> {
        override fun createFromParcel(parcel: Parcel): PriceEntity {
            return PriceEntity(parcel)
        }

        override fun newArray(size: Int): Array<PriceEntity?> {
            return arrayOfNulls(size)
        }
    }
}