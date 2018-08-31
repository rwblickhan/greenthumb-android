package com.example.sherryuan.greenthumb.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sherryuan on 2018-08-29.
 */

@Dao
public interface PlantDao {

    // find by ID query
    // retrieve the Plant with the correct ID from the database
    @Query("SELECT * FROM Plants WHERE id = :id")
    Flowable<List<Plant>> findById(Integer id);

    // insert any number of PicNotes into the database
    // if any IDs conflict with a previously inserted PicNote, replace it
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Plant... plants);

    // insert a single Plant into the database
    // if the ID conflicts with a previously inserted PicNote, replace it
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Plant plant);

    // delete a Plant from the database
    @Delete
    void delete(Plant plant);

    // retrieve all Plants from the database
    @Query("SELECT * FROM Plants")
    Flowable<List<Plant>> loadAll();
}
