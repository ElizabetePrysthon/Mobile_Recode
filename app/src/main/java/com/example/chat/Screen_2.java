package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class Screen_2 extends AppCompatActivity {

    public static final String RECEIVED_MESSAGE = "RECEIVED";

    TextView message;
    EditText edit_message2;
    Button btnSubmit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edit_message2 = findViewById(R.id.ed_message2);
        message = findViewById(R.id.tv_received2);
        btnSubmit2 = findViewById(R.id.bt_submit2);

        Bundle extras = getIntent().getExtras();
        if (extras !=null) {
            String previousMessage = extras.getString(Screen_1.SEND_MESSAGE);
            message.setText(previousMessage);
        }

        btnSubmit2.setOnClickListener(v -> {
            Intent intent = new Intent();
            String newMessage = edit_message2.getText().toString();
            intent.putExtra(RECEIVED_MESSAGE, newMessage);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}




