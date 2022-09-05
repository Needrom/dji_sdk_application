package com.dji.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import dji.v5.common.error.IDJIError;
import dji.v5.common.register.DJISDKInitEvent;
import dji.v5.manager.SDKManager;
import dji.v5.manager.interfaces.SDKManagerCallback;

import android.os.Bundle;
import android.util.Log;

import org.aspectj.runtime.reflect.Factory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerApp();
    }

    private void registerApp() {
        SDKManager.getInstance().init(this, new SDKManagerCallback() {

            @Override
            public void onRegisterSuccess() {
                Log.e(TAG, "myApp onRegisterSuccess");
            }

            @Override
            public void onRegisterFailure(IDJIError error) {
                Log.e(TAG, "myApp onRegisterFailure");
            }

            @Override
            public void onProductDisconnect(int productId) {
                Log.e(TAG, "myApp onProductDisconnect");
            }

            @Override
            public void onProductConnect(int productId) {
                Log.e(TAG, "myApp onProductConnect");
            }

            @Override
            public void onProductChanged(int productId) {
                Log.e(TAG, "myApp onProductChanged");
            }

            @Override
            public void onInitProcess(DJISDKInitEvent event, int totalProcess) {
                Log.e(TAG, "myApp onInitProcess");
                if (event == DJISDKInitEvent.INITIALIZE_COMPLETE) {
                    Log.e(TAG, "myApp start registerApp");
                    SDKManager.getInstance().registerApp();
                }
            }

            @Override
            public void onDatabaseDownloadProgress(long current, long total) {
                Log.e(TAG, "myApp onDatabaseDownloadProgress ");
            }
        });
    }
}