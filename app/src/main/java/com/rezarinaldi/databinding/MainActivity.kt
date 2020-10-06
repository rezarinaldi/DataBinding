package com.rezarinaldi.databinding

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rezarinaldi.databinding.databinding.ActivityMainBinding
import com.rezarinaldi.databinding.models.Mahasiswa
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var pilihanKelamin: String = "Laki Laki"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.edtTanggalLahir.setOnClickListener {
            datePicker()
        }

        binding.btnSubmit.setOnClickListener {
            dataIntent()
        }

        binding.radioLakiLaki.setOnCheckedChangeListener { _, b ->
            if (b) {
                pilihanKelamin = "Laki Laki"
                Log.e("data", pilihanKelamin)
            }
        }
        binding.radioPerempuan.setOnCheckedChangeListener { _, b ->
            if (b) {
                pilihanKelamin = "Perempuan"
                Log.e("data", pilihanKelamin)
            }
        }
    }

    private fun datePicker() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth ->
                val bulan = monthOfYear + 1
                binding.edtTanggalLahir.setText("$dayOfMonth/$bulan/$year")
            },
            year,
            month,
            day
        )
        dpd.show()
    }

    private fun dataIntent() {
        val dataMhs = Mahasiswa(
            nama = binding.edtNama.text.toString(),
            nim = binding.edtNim.text.toString(),
            tanggalLahir = binding.edtTanggalLahir.text.toString(),
            jenisKelamin = pilihanKelamin,
            jurusan = binding.spinnerJurusan.selectedItem.toString()
        )

        val resultIntent = Intent(this, DetailActivity::class.java)
        resultIntent.putExtra("MAHASISWA", dataMhs)
        startActivity(resultIntent)
    }
}