package com.example.bestf.marioclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class C_MainActivity extends AppCompatActivity {
    boolean manager=true;   //***********수정
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView idText = (TextView) findViewById(R.id.idText);
        TextView passwordText = (TextView) findViewById(R.id.passwordText);
        TextView welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);
        Button equipmentStateButton = (Button) findViewById(R.id.equipmentStateButton);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPassword = intent.getStringExtra("userPassword");
        String message = "환영합니다\n" + userID + "님!";

        idText.setText(userID);
        passwordText.setText(userPassword);
        welcomeMessage.setText(message);

        equipmentStateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(manager){   //***********수정
                    Intent workerList = new Intent(C_MainActivity.this, M_WorkerListActivity.class);
                    C_MainActivity.this.startActivity(workerList);
                    finish();
                }
                else {
                    Intent equipmentStateIntent = new Intent(C_MainActivity.this, W_EquipmentStateActivity.class);
                    C_MainActivity.this.startActivity(equipmentStateIntent);
                    finish();
                }
            }
        });
    }
}
