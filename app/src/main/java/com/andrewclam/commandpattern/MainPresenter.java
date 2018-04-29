package com.andrewclam.commandpattern;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.andrewclam.commandpattern.command.Command;
import com.andrewclam.commandpattern.command.GarageDoorOpenCommand;
import com.andrewclam.commandpattern.command.LightOffCommand;
import com.andrewclam.commandpattern.command.LightOnCommand;
import com.andrewclam.commandpattern.command.NoCommand;
import com.andrewclam.commandpattern.models.GarageDoorImpl;
import com.andrewclam.commandpattern.models.LightImpl;
import com.andrewclam.commandpattern.vendorapi.GarageDoor;
import com.andrewclam.commandpattern.vendorapi.Light;

/**
 * Simple implementation of a {@link MainContract.Presenter} class
 */
public class MainPresenter implements MainContract.Presenter{

  @Nullable
  private MainContract.View mView;

  @Override
  public void setView(MainContract.View view) {
    mView = view;
  }

  @Override
  public void dropView() {
    mView = null;
  }

  @NonNull
  private final SimpleRemoteControl mRemoteControl;

  MainPresenter(){
    mRemoteControl = new SimpleRemoteControl(3);
    setupRemoteControl();
  }

  private void setupRemoteControl(){
    // Create "light on" and "light off" command
    // Create the receiver
    Light light = new LightImpl();
    // Set the receivers to the concrete command
    Command lightOnCommand = new LightOnCommand(light);
    Command lightOffCommand = new LightOffCommand(light);
    mRemoteControl.setCommand(0,lightOnCommand,lightOffCommand);

    // Create "garage open" and "garage close" command
    GarageDoor garageDoor = new GarageDoorImpl();
    Command garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
    mRemoteControl.setCommand(1,garageDoorOpenCommand,new NoCommand());
  }

  @Override
  public void onLightOnButtonClicked() {
    mRemoteControl.onOnButtonClicked(0);
    if (mView != null) mView.showResultMsg("light on, see log for impl");
  }

  @Override
  public void onLightOffButtonClicked() {
    mRemoteControl.onOffButtonClicked(0);
    if (mView != null) mView.showResultMsg("light off, see log for impl");
  }

  @Override
  public void onGarageDoorOpenButtonClicked() {
    mRemoteControl.onOnButtonClicked(1);
    if (mView != null) mView.showResultMsg("garage opened, see log for impl");
  }

  @Override
  public void onUndoButtonClicked() {
    mRemoteControl.onUndoButtonClicked();
  }


}
