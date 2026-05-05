package com.pf.turismoandalucia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.pf.turismoandalucia.data.AppDatabase
import com.pf.turismoandalucia.data.Place
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlaceViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).placeDao()
    val allPlaces: LiveData<List<Place>> = dao.getAllPlaces()

    fun insert(place: Place) = viewModelScope.launch(Dispatchers.IO) { dao.insert(place) }
    fun update(place: Place) = viewModelScope.launch(Dispatchers.IO) { dao.update(place) }
    fun delete(place: Place) = viewModelScope.launch(Dispatchers.IO) { dao.delete(place) }
    fun getPlaceById(id: Int): LiveData<Place> = dao.getPlaceById(id)
}