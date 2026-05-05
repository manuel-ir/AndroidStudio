package com.pf.turismoandalucia

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pf.turismoandalucia.data.Place
import com.pf.turismoandalucia.databinding.ActivityDetailBinding
import com.pf.turismoandalucia.viewmodel.PlaceViewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val viewModel: PlaceViewModel by viewModels()
    private var currentPlace: Place? = null
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val placeId = intent.getIntExtra("PLACE_ID", -1)

        viewModel.getPlaceById(placeId).observe(this) { place ->
            place?.let {
                currentPlace = it
                binding.tvName.text = it.name
                binding.tvProvince.text = it.province
                binding.tvDescription.text = it.description
            }
        }

        // Requiere que pongas un audio en res/raw/sound_nature.mp3
        mediaPlayer = MediaPlayer.create(this, R.raw.sound_nature)
        mediaPlayer?.start()

        binding.btnEdit.setOnClickListener {
            val intent = Intent(this, AddEditActivity::class.java)
            intent.putExtra("PLACE_ID", placeId)
            startActivity(intent)
        }

        binding.btnDelete.setOnClickListener {
            currentPlace?.let {
                viewModel.delete(it)
                Toast.makeText(this, "Lugar eliminado", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}