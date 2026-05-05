package com.pf.turismoandalucia.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlaceDao {
    @Query("SELECT * FROM places_table ORDER BY name ASC")
    fun getAllPlaces(): LiveData<List<Place>>

    @Query("SELECT * FROM places_table WHERE id = :placeId")
    fun getPlaceById(placeId: Int): LiveData<Place>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(place: Place)

    @Update
    suspend fun update(place: Place)

    @Delete
    suspend fun delete(place: Place)
}