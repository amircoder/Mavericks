package com.multithread.dindinntest.domain.entity

import android.os.Parcel
import android.os.Parcelable

data class FoodEntity(
    val id: String = "",
    val title: String = "",
    val price: PriceEntity = PriceEntity(),
    val imageUrl: String  = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readParcelable(PriceEntity::class.java.classLoader) ?: PriceEntity(),
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeParcelable(price, flags)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FoodEntity> {
        override fun createFromParcel(parcel: Parcel): FoodEntity {
            return FoodEntity(parcel)
        }

        override fun newArray(size: Int): Array<FoodEntity?> {
            return arrayOfNulls(size)
        }
    }
}