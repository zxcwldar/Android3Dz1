package com.example.android3dz1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.android3dz1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements CounterContracts.CounterView {
    ActivityMainBinding binding;
    CounterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = Injector.attachPresenter();
        presenter.attachView(this);
        initListener();
    }

    private void initListener() {
        binding.incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.increment();
                presenter.change();
            }
        });
        binding.decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.decrement();
                presenter.change();
            }
        });
    }
    public void updateCounter ( int count){
        binding.numberTv.setText(String.valueOf(count));
    }

    @Override
    public void tenCount() {

    }

    @Override
    public void greenText() {
        binding.numberTv.setTextColor(Color.parseColor("#1d9967"));

    }
}