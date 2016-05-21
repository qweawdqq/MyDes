package com.example.administrator.mydes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mydes.DesUntils.MyDesUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.btn_jiami)
    Button btnJiami;
    @Bind(R.id.btn_jiemi)
    Button btnJiemi;

    private String key = "12345678";
    //指定加密明文
    String text = "中文好事吗";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tv.setText(text);

    }


    @OnClick({R.id.btn_jiami, R.id.btn_jiemi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_jiami:

                try {
                    String xx = MyDesUtils.encode(key, text);
                    tv.setText(xx);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_jiemi:


                try {
                    Log.e("onClick: ", tv.getText().toString());
                    String y = MyDesUtils.decode(key, tv.getText().toString());
                    Log.e("onClick22: ", y);
                    tv.setText(y);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
        }
    }
}
