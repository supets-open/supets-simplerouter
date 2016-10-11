package com.supets.pet.router.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.supets.pet.router.R;
import com.supets.pet.supetsrouter.utils.UINavigation;
import com.supets.pet.supetsrouter.utils.UINavigationBase;

public class CleanTopActivity extends BaseActivity implements View.OnClickListener {

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


        Toast.makeText(this,getIntent().getStringExtra("id"),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            Intent intent = new Intent(this, CleanTopActivity.class);
            //UINavigation.pushCleanTopRecycler(this, intent);
           // UINavigation.pushCleanTopRecycler2(this, intent);
            UINavigation.pushCleanTop(this, intent);
        }
    }
}

