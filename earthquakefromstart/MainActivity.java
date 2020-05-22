package com.example.earthquakefromstart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C1019R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                MainActivity.this.startActivity(new Intent(MainActivity.this, HomeActivity.class));
                MainActivity.this.finish();
            }
        }, 2000);
    }
}
