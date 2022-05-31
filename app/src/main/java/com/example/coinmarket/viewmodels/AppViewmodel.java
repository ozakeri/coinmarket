package com.example.coinmarket.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.coinmarket.AppRepository;
import com.example.coinmarket.Models.cryptolistmodel.AllMarketModel;
import com.example.coinmarket.Models.cryptolistmodel.CryptoMarketDataModel;
import com.example.coinmarket.R;
import com.example.coinmarket.RoomDb.Entites.MarketDataEntity;
import com.example.coinmarket.RoomDb.Entites.MarketListEntity;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

@HiltViewModel
public class AppViewmodel extends AndroidViewModel {

    MutableLiveData<ArrayList<Integer>> mutableLiveData = new MutableLiveData<>();

    @Inject
    AppRepository appRepository;

    @Inject
    public AppViewmodel(@NonNull Application application) {
        super(application);
        getViewPagerData();

    }

    public Observable<AllMarketModel> MarketFutureCall(){
        return appRepository.marketListFutureCall();
    }

    MutableLiveData<ArrayList<Integer>> getViewPagerData(){
        ArrayList<Integer> pics = new ArrayList();
        pics.add(R.drawable.p1);
        pics.add(R.drawable.p2);
        pics.add(R.drawable.p3);
        pics.add(R.drawable.p4);
        pics.add(R.drawable.p5);

        mutableLiveData.postValue(pics);

        return mutableLiveData;
    }

    public MutableLiveData<ArrayList<Integer>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void insertAllMarket(AllMarketModel allMarketModel){
        appRepository.InsertAllMarket(allMarketModel);
    }

    public Flowable<MarketListEntity> getAllMarketData(){
        return appRepository.getAllMarketData();
    }


    public void insertCryptoDataMarket(CryptoMarketDataModel cryptoMarketDataModel) {
        appRepository.InsertCryptoDataMarket(cryptoMarketDataModel);
    }

    public Flowable<MarketDataEntity> getCryptoMarketData(){
        return appRepository.getCryptoMarketData();
    }


}
