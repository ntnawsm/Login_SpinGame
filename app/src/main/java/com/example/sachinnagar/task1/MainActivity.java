package com.example.sachinnagar.task1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.adefruandta.spinningwheel.SpinningWheelView;

public class MainActivity extends AppCompatActivity implements SpinningWheelView.OnRotationListener<String> {

    private SpinningWheelView wheelView;

    private Button rotate,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wheelView = (SpinningWheelView) findViewById(R.id.wheel);

        rotate = (Button) findViewById(R.id.rotate);
        logout = (Button) findViewById(R.id.logout);

        wheelView.setItems(R.array.dummy);
        wheelView.setOnRotationListener(this);

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // max angle 50
                // duration 10 second
                // every 50 ms rander rotation
                wheelView.rotate(50, 3000, 50);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onRotation() {
        Log.d("XXXX", "On Rotation");
    }

    @Override
    public void onStopRotation(String item) {
        Toast.makeText(this, item, Toast.LENGTH_LONG).show();
    }
}
