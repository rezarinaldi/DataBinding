package com.rezarinaldi.databinding.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mahasiswa(
    var nama: String,
    var nim: String,
    var tanggalLahir: String,
    var jenisKelamin: String,
    var jurusan: String
) : Parcelable
