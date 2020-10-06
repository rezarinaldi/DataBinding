package com.rezarinaldi.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rezarinaldi.databinding.databinding.ActivityDetailBinding
import com.rezarinaldi.databinding.models.Mahasiswa

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val dataMahasiswa = intent.getParcelableExtra<Mahasiswa>("MAHASISWA")
        binding.mahasiswa = dataMahasiswa
    }
}