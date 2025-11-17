package com.example.test_fragments;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragmentOne extends Fragment {

    private TextView tv;
    private Button btnHello;

    public FragmentOne() {
        super(R.layout.fragment_one); // définit directement le layout XML
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tv = view.findViewById(R.id.textOne);
        btnHello = view.findViewById(R.id.btnHello);

        // Action du bouton
        btnHello.setOnClickListener(v -> tv.setText("Bonjour depuis Fragment 1 !"));
    }

    // ========================
    //   Cycle de vie Fragment
    // ========================

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FragmentOne", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("FragmentOne", "onPause()");
    }
}
