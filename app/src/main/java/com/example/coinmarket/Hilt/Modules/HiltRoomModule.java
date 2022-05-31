package com.example.coinmarket.Hilt.Modules;

import android.content.Context;

import com.example.coinmarket.RoomDb.AppDataBase;
import com.example.coinmarket.RoomDb.RoomDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class HiltRoomModule {

    @Provides
    @Singleton
    AppDataBase ProvideAppDatabase(@ApplicationContext Context context){
        return AppDataBase.getInstance(context);
    }


    @Provides
    @Singleton
    RoomDao ProvideRoomDao(AppDataBase appDatabase){
        return appDatabase.roomDao();
    }
}
