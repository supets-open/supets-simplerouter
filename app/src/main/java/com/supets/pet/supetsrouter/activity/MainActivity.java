package com.supets.pet.supetsrouter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.supets.pet.supetsrouter.R;
import com.supets.pet.supetsrouter.utils.UINavigation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        mTextView = (TextView) findViewById(R.id.test);
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);

        mTextView.setText("android模式导航");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            UINavigation.pushStandard(this, StandLandActivity.class, new Bundle());
        }
        if (v.getId() == R.id.btn1) {
            UINavigation.pushStandard(this, SingleTaskActivity.class, new Bundle());
        }
        if (v.getId() == R.id.btn2) {
            UINavigation.pushStandard(this, SingleInstanceActivity.class, new Bundle());
        }
        if (v.getId() == R.id.btn3) {
            UINavigation.pushStandard(this, SingleTopActivity.class, new Bundle());
        }
        if (v.getId() == R.id.btn4) {
            UINavigation.pushStandard(this, CleanTopActivity.class, new Bundle());
        }

    }
}
