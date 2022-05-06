package com.shayna.clevertapapp;
import android.app.NotificationManager;        //added by CleverTap Assistant

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static String TAG="Shayna";
    CleverTapAPI clevertapDefaultInstance;
    String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());   //Initializing the CleverTap SDK

        clevertapDefaultInstance.setDebugLevel(3);
        super.onCreate(savedInstanceState);
        Log.i(TAG,"clevertapDefaultInstance :: "+clevertapDefaultInstance);
        setContentView(R.layout.activity_main);
		CleverTapAPI.createNotificationChannel(getApplicationContext(),"CleverTap","mychannel","lDescription",NotificationManager.IMPORTANCE_MAX,true);        //added by CleverTap Assistant
        initViews();		//added by CleverTap Assistant
    }

    private void initViews() {
        Button submitBtn= findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                HashMap<String, Object> OnUserLoginProperties = new HashMap<String, Object>();//added by CleverTap Assistant
                OnUserLoginProperties.put("Email ", " jidesh+shaynasharma094@clevertap.com");//added by CleverTap Assistant
                clevertapDefaultInstance.onUserLogin(OnUserLoginProperties);//added by CleverTap Assistant

                HashMap<String, Object> ProfilePush = new HashMap<String, Object>();//added by CleverTap Assistant
                ProfilePush.put(" Product ID ", "1");//added by CleverTap Assistant
                ProfilePush.put(" Product Name ", "CleverTap");
                ProfilePush.put(" Product Image ", "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg");

                clevertapDefaultInstance.pushProfile(ProfilePush);//added by CleverTap Assistant
            }
        });
    }
}
