package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private Button button, buttonDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        buttonDefault = findViewById(R.id.button_default);

        //custom toast
        LayoutInflater customToastInflater = getLayoutInflater();
        final View customToastView = customToastInflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_parent));
        final TextView text = customToastView.findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(getApplicationContext());
                text.setText("Toast berhasil ditampilkan xD");
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(customToastView);
                toast.setGravity(Gravity.TOP,0,30);
                toast.show();
            }
        });

        buttonDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Ini default Toast", Toast. LENGTH_LONG).show();
            }
        });
    }
}