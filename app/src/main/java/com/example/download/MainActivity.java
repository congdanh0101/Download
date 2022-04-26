package com.example.download;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {

    EditText ed_url;
    Button btn_getPageSource;
    TextView tv_content, tv_https;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_url = findViewById(R.id.ed_url);
        btn_getPageSource = findViewById(R.id.btn_getPageSource);
        tv_content = findViewById(R.id.tv_content);
        tv_https = findViewById(R.id.tv_https);

        btn_getPageSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ion.with(getApplicationContext()).load(tv_https.getText().toString().trim() +
                        ed_url.getText().toString().trim())
                        .asString().setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        tv_content.setText(result);
                    }
                });
            }
        });
    }
}