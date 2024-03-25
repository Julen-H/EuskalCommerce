package com.talde1.commerceapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.talde1.commerceapp.model.Settings;

import java.util.List;
@Dao
public interface SettingsDAO {
        @Query("SELECT * FROM settings")
        LiveData<List<Settings>> getSettings();

        @Query("SELECT * FROM settings WHERE userId = :id")
        LiveData<Settings> getUserSettings(int id);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(Settings settings);
        @Update
        void update(Settings settings);
        @Delete
        void delete(Settings settings);
}
