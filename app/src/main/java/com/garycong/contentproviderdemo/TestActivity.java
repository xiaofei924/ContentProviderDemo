package com.garycong.contentproviderdemo;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URI;

public class TestActivity extends AppCompatActivity {
    private TextView mTestTxt;
    private Button mQueryBtn;
    private Button mInsertBtn;
    private Button mUpdateBtn;
    private Button mDeleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mTestTxt = findViewById(R.id.test_txt);
        mQueryBtn = findViewById(R.id.query_btn);
        mInsertBtn = findViewById(R.id.insert_btn);
        mUpdateBtn = findViewById(R.id.update_btn);
        mDeleteBtn = findViewById(R.id.delete_btn);
        final Uri uri = Uri.parse("content://com.garycong.test.provider");
        mQueryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                StringBuilder text = new StringBuilder();
                if (cursor == null) {
                    return;
                }
                while (cursor.moveToNext()) {
                    String time = cursor.getString(1);
                    String content = cursor.getString(2);
                    text.append(time).append(" ").append(content);
                }
                if (TextUtils.isEmpty(text.toString())) {
                    mTestTxt.setText("data is null!!!");
                } else {
                    mTestTxt.setText(text.toString());
                }
                cursor.close();
            }
        });

        mInsertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    private void initData() {
    }
}