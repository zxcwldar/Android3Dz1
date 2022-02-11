package com.example.android3dz1;

public class CounterContracts {
    interface CounterView {
        void updateCounter( int count);
        void tenCount();
        void greenText();
    }
    interface Presenter{
        void increment();
        void attachView(CounterView counterView);
        void change();

    }
}
