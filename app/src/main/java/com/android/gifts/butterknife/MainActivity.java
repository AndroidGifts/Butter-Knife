package com.android.gifts.butterknife;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toast_edit_text) EditText toastEditText;
    @BindView(R.id.fragment_container) FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new FragmentA())
                .commit();
    }

    @OnClick(R.id.make_toast_button)
    public void sayHi(Button button) {
        Toast.makeText(getApplicationContext(), toastEditText.getText().toString(), Toast.LENGTH_SHORT).show();

        // we defined a specific type as input (Button button), and it will automatically be cast.
        // so we can control it easily like this
        button.setText("Toast Done");
    }
}