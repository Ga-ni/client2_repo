package com.example.bestf.marioclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class W_EquipmentStateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_state);

        final TextView titleTextView = (TextView) findViewById(R.id.titleTextView);
        final TextView equipmentCountTiltle = (TextView) findViewById(R.id.equipmentCountTiltle);
        final TextView equipmentCount = (TextView) findViewById(R.id.equipmentCount);;
        final ImageView equipment1 = (ImageView) findViewById(R.id.equipment1);
        final ImageView equipment2 = (ImageView) findViewById(R.id.equipment2);
        final ImageView equipment3 = (ImageView) findViewById(R.id.equipment3);
        final Button refresh = (Button) findViewById(R.id.refresh);

    }
}
