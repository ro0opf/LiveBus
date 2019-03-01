package com.ro0opf.livebus.livebus;

import java.util.HashMap;

import androidx.lifecycle.MutableLiveData;

public class LiveBus {
    private HashMap<String, MutableLiveData<Object>> dataSet;
    private LiveBus() {
        dataSet = new HashMap<>();
    }

    public static LiveBus getInstance() {
        return LazyInit.INSTANCE;
    }

    private static class LazyInit {
        private static final LiveBus INSTANCE = new LiveBus();
    }

    public void sendBus(String key, Object object) {
        MutableLiveData<Object> mutableLiveData;
        if(dataSet.get(key) == null){
            mutableLiveData = new MutableLiveData<>();
            mutableLiveData.postValue(object);
            dataSet.put(key, mutableLiveData);
        }else{
            mutableLiveData = dataSet.get(key);
            mutableLiveData.postValue(object);
        }
    }

    public MutableLiveData<Object> getBus(String key) {
        if(dataSet.get(key) == null){
            MutableLiveData<Object> mutableLiveData = new MutableLiveData<>();
            dataSet.put(key, mutableLiveData);
        }
        return dataSet.get(key);
    }

    public void removeBus(String key){
        dataSet.remove(key);
    }
}
