package com.pf.turismoandalucia

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pf.turismoandalucia.data.Place
import com.pf.turismoandalucia.databinding.ActivityAddEditBinding
import com.pf.turismoandalucia.viewmodel.PlaceViewModel

class AddEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddEditBinding
    private val viewModel: PlaceViewModel by viewModels()
    private var placeId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        placeId = intent.getIntExtra("PLACE_ID", -1)

        if (placeId != -1) {
            viewModel.getPlaceById(placeId).observe(this) { place ->
                place?.let {
                    binding.etName.setText(it.name)
                    binding.etProvince.setText(it.province)
                    binding.etDescription.setText(it.description)
                }
            }
        }

        binding.btnSave.setOnClickListener { savePlace() }
    }

    private fun savePlace() {
        val name = binding.etName.text.toString()
        val province = binding.etProvince.text.toString()
        val desc = binding.etDescription.text.toString()

        if (name.isEmpty() || province.isEmpty()) {
            Toast.makeText(this, "Rellena los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val place = Place(id = if (placeId == -1) 0 else placeId, name, province, desc)
        if (placeId == -1) viewModel.insert(place) else viewModel.update(place)
        finish()
    }
}