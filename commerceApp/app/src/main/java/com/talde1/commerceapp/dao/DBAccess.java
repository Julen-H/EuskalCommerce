package com.talde1.commerceapp.dao;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.talde1.commerceapp.Converter.Converters;
import com.talde1.commerceapp.model.Bill;
import com.talde1.commerceapp.model.Client;
import com.talde1.commerceapp.model.Product;
import com.talde1.commerceapp.model.Settings;
import com.talde1.commerceapp.model.User;


@Database(entities = {Client.class, Product.class, User.class, Bill.class, Settings.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class DBAccess extends RoomDatabase {

        private static volatile DBAccess INSTANCE;

        public abstract ClientDAO getClientDAO();
        public abstract ProductDAO getProductDAO();
        public abstract UserDAO getUserDAO();
        public abstract SettingsDAO getSettingDAO();
        public abstract BillDAO getBillDAO();

        public static DBAccess obtainInstance(final Context context) {
                if (INSTANCE == null) {
                        synchronized ((DBAccess.class)) {
                                if (INSTANCE == null) {
                                        INSTANCE = Room.databaseBuilder(context,
                                                        DBAccess.class, "commercedb.db")
                                                .fallbackToDestructiveMigration()
                                                .build();
                                }
                        }
                }
                return INSTANCE;
        }
}


