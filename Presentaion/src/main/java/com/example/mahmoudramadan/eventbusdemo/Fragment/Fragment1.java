package com.example.mahmoudramadan.eventbusdemo.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mahmoudramadan.eventbusdemo.Event.AddButtonEvent;
import com.example.mahmoudramadan.eventbusdemo.R;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Mahmoud.Ramadan on 11/16/2016.
 */

public class Fragment1 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment1,container,false);

        final Button click =(Button)v.findViewById(R.id.button);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new AddButtonEvent());
            }
        });
        return v;
    }
}
