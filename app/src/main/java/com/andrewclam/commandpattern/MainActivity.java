package com.andrewclam.commandpattern;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.andrewclam.commandpattern.command.GarageDoorOpenCommand;
import com.andrewclam.commandpattern.command.LightOnCommand;
import com.andrewclam.commandpattern.models.GarageDoorImpl;
import com.andrewclam.commandpattern.models.LightImpl;
import com.andrewclam.commandpattern.vendorapi.GarageDoor;
import com.andrewclam.commandpattern.vendorapi.Light;

/**
 * Simple implementation of a {@link MainContract.View} class
 */
public class MainActivity extends AppCompatActivity implements MainContract.View{

  @NonNull
  private final MainContract.Presenter mPresenter = new MainPresenter();

  @Override
  protected void onResume() {
    mPresenter.setView(this);
    super.onResume();
  }

  @Override
  protected void onPause() {
    mPresenter.dropView();
    super.onPause();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    View button1 = findViewById(R.id.command_light_on);
    button1.setOnClickListener(view -> {
      mPresenter.onLightOnButtonClicked();
    });

    View button2 = findViewById(R.id.command_light_off);
    button2.setOnClickListener(view -> {
      mPresenter.onLightOffButtonClicked();
    });

    View button3 = findViewById(R.id.command_garage_open);
    button3.setOnClickListener(view -> {
      mPresenter.onGarageDoorOpenButtonClicked();
    });

  }

  @Override
  public void showResultMsg(String msg) {
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
  }
}
