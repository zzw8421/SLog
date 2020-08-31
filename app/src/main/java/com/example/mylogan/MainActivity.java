package com.example.mylogan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ilanchuang.slog.Slog;
import com.ilanchuang.slog.helper.SLocalLogHelepr;


public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_print).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Slog.i(TAG, "click main print button");
                Slog.e(TAG, "print error log");
                Slog.w(TAG, "print warn log");
                Slog.v(TAG, "print verbose log");
                Slog.d(TAG, "print debug log");
            }
        });
        findViewById(R.id.tv_upload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Slog.upload(new SLocalLogHelepr.OnLogUploadListener() {
                    @Override
                    public void onCompleted(int code, String msg) {
                        Log.i(TAG, "onCompleted: msg== " + msg);
                        Log.i(TAG, "onCompleted: code== " + code);
                    }
                });
            }
        });
    }
}
