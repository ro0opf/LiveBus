package com.ro0opf.livebus.sameple;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ro0opf.livebus.livebus.LiveBus;

import static java.lang.Thread.sleep;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private LiveBus liveBus;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        liveBus = LiveBus.getInstance();


        new Thread(() -> {
            int i = 1;
            Board b = new Board("hi", "heee", i);
            while (true) {
                liveBus.sendBus("test", b);
                Log.e("##home", i+"");
                i++;
                b.setAge(i);
                try {
                    sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
