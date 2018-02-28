package shuuya.palkkavahti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Miisu on 21.1.2017.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        startActivity(new Intent(SplashActivity.this, MenuActivity.class));
        finish();
    }
}