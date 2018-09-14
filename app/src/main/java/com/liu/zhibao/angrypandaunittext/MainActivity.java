package com.liu.zhibao.angrypandaunittext;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.liu.zhibao.angrypandaunittext.androidtest.Player;
import com.liu.zhibao.angrypandaunittext.androidtest.utils.FileUtils;

public class MainActivity extends Activity {

    private Button mBtn;
    private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn=(Button)findViewById(R.id.button);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.text);
                EditText editText = (EditText) findViewById(R.id.edit);
                textView.setText("Hello, " + editText.getText().toString() + "!");
            }
        });

        String jsonStr = FileUtils.getFromAssets(MainActivity.this,"weather.json");
        Log.i("JSON",jsonStr);

        DataManager.getInstance().loadJson(MainActivity.this);

        mPlayer=new Player(MainActivity.this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        mPlayer.soundPoolLoad("tone/conn.wav");

    }
}
