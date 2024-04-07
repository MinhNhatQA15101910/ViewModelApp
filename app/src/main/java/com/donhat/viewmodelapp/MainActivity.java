package com.donhat.viewmodelapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.donhat.viewmodelapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding _activityMainBinding;
    private MyViewModel _myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        _activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        _myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        _activityMainBinding.setMyViewModel(_myViewModel);

        _myViewModel.getCounter().observe(this, counter -> {
            _activityMainBinding.counterTextView.setText("" + counter);
        });
    }
}