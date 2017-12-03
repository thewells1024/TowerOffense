package cpe307.team6.toweroffense;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import cpe307.team6.toweroffense.game.GameSurface;

public class StartScreen extends AppCompatActivity {

   @Override
   protected void onCreate(final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      // Set fullscreen
      this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
              WindowManager.LayoutParams.FLAG_FULLSCREEN);

      // Set No Title
      this.requestWindowFeature(Window.FEATURE_NO_TITLE);

      setContentView(new GameSurface(this));
   }
}
