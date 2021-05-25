package com.example.smartparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class ParkingSlot extends AppCompatActivity {

    private ImageView CarInsideTheSlot1, CarOutsideTheSlot1, CarInsideTheSlot2, CarOutsideTheSlot2, CarInsideTheSlot3, CarOutsideTheSlot3;


    int slot_1;
    int slot_2;
    int slot_3;

    private DatabaseReference datareference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_slot);


        CarInsideTheSlot1 = (ImageView) findViewById(R.id.CarInsideTheSlot1);
        CarOutsideTheSlot1 = (ImageView) findViewById(R.id.CarOutsideTheSlot1);

        CarInsideTheSlot2 = (ImageView) findViewById(R.id.CarInsideTheSlot2);
        CarOutsideTheSlot2 = (ImageView) findViewById(R.id.CarOutsideTheSlot2);

        CarInsideTheSlot3 = (ImageView) findViewById(R.id.CarInsideTheSlot3);
        CarOutsideTheSlot3 = (ImageView) findViewById(R.id.CarOutsideTheSlot3);


        datareference.child("ParkingStatus").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            //ParkingHelperClass parkingHelperClass = snapshot.getValue(ParkingHelperClass.class);

                if (datareference != null) {
                    if(slot_1 == 0)
                    {
                        CarOutsideTheSlot1.setVisibility(View.GONE);
                        CarInsideTheSlot1.setVisibility(View.VISIBLE);
                    }
                    else if(slot_1 == 1)
                    {
                        CarOutsideTheSlot1.setVisibility(View.VISIBLE);
                        CarInsideTheSlot1.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ParkingSlot.this, "Something wrong happened", Toast.LENGTH_LONG).show();

            }
        });
        datareference.child("ParkingStatus").child("Slot2").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               // ParkingHelperClass parkingHelperClass = snapshot.getValue(ParkingHelperClass.class);

                if (datareference != null) {
                    if(slot_2 == 0)
                    {
                        CarOutsideTheSlot2.setVisibility(View.GONE);
                        CarInsideTheSlot2.setVisibility(View.VISIBLE);
                    }
                    else if(slot_2 == 1)
                    {
                        CarOutsideTheSlot2.setVisibility(View.VISIBLE);
                        CarInsideTheSlot2.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ParkingSlot.this, "Something wrong happened", Toast.LENGTH_LONG).show();

            }
        });

        datareference.child("ParkingStatus").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            //ParkingHelperClass parkingHelperClass = snapshot.getValue(ParkingHelperClass.class);

                if (datareference != null) {
                    if(slot_3 == 0)
                    {
                        CarInsideTheSlot3.setVisibility(View.GONE);
                        CarOutsideTheSlot3.setVisibility(View.VISIBLE);
                    }
                    else if(slot_3 == 1)
                    {
                        CarOutsideTheSlot3.setVisibility(View.VISIBLE);
                        CarInsideTheSlot3.setVisibility(View.GONE);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ParkingSlot.this, "Something wrong happened", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void callStartScreen(View view) {
        Intent intent = new Intent(ParkingSlot.this, StartScreen.class);
        startActivity(intent);
    }

}