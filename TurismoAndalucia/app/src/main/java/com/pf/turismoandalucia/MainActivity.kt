package com.pf.turismoandalucia

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pf.turismoandalucia.databinding.ActivityMainBinding
import com.pf.turismoandalucia.viewmodel.PlaceViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val placeViewModel: PlaceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PlaceAdapter { place ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("PLACE_ID", place.id)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        placeViewModel.allPlaces.observe(this) { places ->
            places?.let { adapter.submitList(it) }
        }

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, AddEditActivity::class.java))
        }
    }
}