package com.example.bestf.marioclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class C_MainActivity extends AppCompatActivity {

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
//        String userAuth = intent.getStringExtra("userAuth");
        String message = "환영합니다\n" + userID + "님!";


        idText.setText(userID);
        passwordText.setText(userPassword);
        welcomeMessage.setText(message);
//      if(userAuth.equals("1")){//1아니면 true
//          Toast.makeText(getApplicationContext(), "관리자 로그인", Toast.LENGTH_SHORT).show();
//      }

        equipmentStateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workerList = new Intent(C_MainActivity.this, M_WorkerListActivity.class);
                C_MainActivity.this.startActivity(workerList);
                finish();
//                if(userAuth.equals("1")){
//                    Intent workerList = new Intent(C_MainActivity.this, M_WorkerListActivity.class);
//                    C_MainActivity.this.startActivity(workerList);
//                    finish();
//                }
//                else {
//                    Intent equipmentStateIntent = new Intent(C_MainActivity.this, W_EquipmentStateActivity.class);
//                    C_MainActivity.this.startActivity(equipmentStateIntent);
//                    finish();
//                }
            }
        });
    }
}
