package com.supets.pet.supetsrouter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.supets.pet.supetsrouter.R;
import com.supets.pet.supetsrouter.utils.UINavigation;

public class SingleTopActivity  extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.test);
        mBtn = (Button) findViewById(R.id.btn);

        mTextView.setText(this.toString());
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
           UINavigation.pushSingleTop(this, SingleTopActivity.class, new Bundle());
        }

    }
}
