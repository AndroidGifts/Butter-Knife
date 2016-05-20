package com.android.gifts.butterknife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentA extends Fragment {

    @BindView(R.id.fragment_text_view) TextView fragmentTextView;

    @BindView(R.id.fragment_layout) FrameLayout fragmentContainer;

    @BindColor(R.color.colorAccent) int fancyColor;

    @BindColor(android.R.color.white) int whiteColor;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_a, container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @OnClick(R.id.color_fragment_btn)
    public void colorFragment() {
        fragmentContainer.setBackgroundColor(fancyColor);

        fragmentTextView.setTextColor(whiteColor);
    }
}
