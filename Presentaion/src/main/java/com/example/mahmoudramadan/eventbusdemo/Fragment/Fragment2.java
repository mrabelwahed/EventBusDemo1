package com.example.mahmoudramadan.eventbusdemo.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mahmoudramadan.eventbusdemo.Event.AddButtonEvent;
import com.example.mahmoudramadan.eventbusdemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Mahmoud.Ramadan on 11/16/2016.
 */

public class Fragment2 extends Fragment {
     TextView text;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment2,container,false);
        text=(TextView) v.findViewById(R.id.textview);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setTextView(AddButtonEvent event){
        int counter=Integer.parseInt(text.getText().toString());
        counter++;
        text.setText(counter+"");
    }
}
