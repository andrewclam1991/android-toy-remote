package com.andrewclam.commandpattern.views;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.andrewclam.commandpattern.R;

/**
 * Simple implementation of a {@link MainContract.View} class
 */
public class MainActivity extends AppCompatActivity implements MainContract.View{

  @NonNull
  private final MainContract.Presenter mPresenter = new FuncMainPresenter();

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
    button1.setOnClickListener(view -> mPresenter.onLightOnButtonClicked());

    View button2 = findViewById(R.id.command_light_off);
    button2.setOnClickListener(view -> mPresenter.onLightOffButtonClicked());

    View button3 = findViewById(R.id.command_garage_open);
    button3.setOnClickListener(view -> mPresenter.onGarageDoorOpenButtonClicked());

    View undoButton = findViewById(R.id.command_undo);
    undoButton.setOnClickListener(view -> mPresenter.onUndoButtonClicked());

  }

  @Override
  public void showResultMsg(String msg) {
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
  }
}
