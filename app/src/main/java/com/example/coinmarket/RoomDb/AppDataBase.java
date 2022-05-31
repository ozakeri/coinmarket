package com.example.coinmarket.RoomDb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.coinmarket.RoomDb.Entites.MarketDataEntity;
import com.example.coinmarket.RoomDb.Entites.MarketListEntity;
import com.example.coinmarket.RoomDb.converters.AllMarketModelConverter;
import com.example.coinmarket.RoomDb.converters.CryptoDataModelConverter;

@TypeConverters({AllMarketModelConverter.class, CryptoDataModelConverter.class})
@Database(entities = {MarketListEntity.class, MarketDataEntity.class},version = 2)
public abstract class AppDataBase extends RoomDatabase {

    private static final String Db_Name = "AppDb";
    private static AppDataBase instance;
    public abstract RoomDao roomDao();

    public static synchronized AppDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,Db_Name)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
