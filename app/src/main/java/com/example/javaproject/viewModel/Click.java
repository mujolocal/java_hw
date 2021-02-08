package com.example.javaproject.viewModel;

import android.widget.LinearLayout;

import com.example.javaproject.view.MainActivity;

public class Click {
    MainActivity mainActivity;
    LinearLayout linearLayout;

    public Click(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }

    public void setLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
    }
}
