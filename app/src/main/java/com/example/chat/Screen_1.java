package com.example.chat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Screen_1 extends AppCompatActivity {
    public static final String SEND_MESSAGE = "SEND";

    TextView textViewReceived;
    EditText editSendText;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewReceived = findViewById(R.id.tv_recebida);
        editSendText = findViewById(R.id.ed_message);
        btnSend = findViewById(R.id.bt_enviar);

        btnSend.setOnClickListener(v -> {
           String sendText = editSendText.getText().toString();

           Intent intent = new Intent(Screen_1.this, Screen_2.class);
           Bundle extras = new Bundle();

           extras.putString(SEND_MESSAGE, sendText);

           intent.putExtras(extras);
           startActivityForResult(intent, 10);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case 10:
                    textViewReceived.setText(data.getStringExtra(Screen_2.RECEIVED_MESSAGE));
                    break;
                default:
                    textViewReceived.setText("Não foi possível receber dados da segunda tela");
            }
        }
    }
}
