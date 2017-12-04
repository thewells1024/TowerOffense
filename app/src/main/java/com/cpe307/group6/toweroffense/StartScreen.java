package com.cpe307.group6.toweroffense;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartScreen extends AppCompatActivity {

   @Override
   protected void onCreate(final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_start_screen);

      final Button playOffline = findViewById(R.id.PlayOfflineButton);
      playOffline.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(final View view) {
            final Intent i = new Intent(getBaseContext(), GameScreen.class);
            startActivity(i);
         }
      });
   }
}
