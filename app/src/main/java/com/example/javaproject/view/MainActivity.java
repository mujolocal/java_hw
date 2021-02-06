package com.example.javaproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.javaproject.R;
import com.example.javaproject.databinding.ActivityMainBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Toast toast;
    private Context context;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        context = getApplicationContext();
        initViews();



    }
    private void initViews(){
        binding.toggleLayoutBtn.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if(checkedId == R.id.grid_btn){

                    Log.d(TAG, "onButtonChecked: toast should have started");
                }else if(checkedId == R.id.list_btn){
                    Log.d(TAG, "onButtonChecked:should have started");
                }
            }
        });

    }
}