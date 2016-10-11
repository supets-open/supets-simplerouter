package com.supets.pet.router.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.supets.pet.router.R;
import com.supets.pet.supetsrouter.utils.UINavigation;

public class SingleTopActivity  extends BaseActivity implements View.OnClickListener {

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
            Intent intent = new Intent(this, SingleTopActivity.class);
            UINavigation.pushSingleTop(this, intent);
        }

    }
}
