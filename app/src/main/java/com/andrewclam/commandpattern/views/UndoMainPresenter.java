package com.andrewclam.commandpattern.views;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.andrewclam.commandpattern.control.UndoRemoteControl;
import com.andrewclam.commandpattern.undo.command.Command;
import com.andrewclam.commandpattern.undo.command.GarageDoorOpenCommand;
import com.andrewclam.commandpattern.undo.command.LightOffCommand;
import com.andrewclam.commandpattern.undo.command.LightOnCommand;
import com.andrewclam.commandpattern.undo.command.NoCommand;
import com.andrewclam.commandpattern.data.models.GarageDoorImpl;
import com.andrewclam.commandpattern.data.models.LightImpl;
import com.andrewclam.commandpattern.data.vendorapi.GarageDoor;
import com.andrewclam.commandpattern.data.vendorapi.Light;

/**
 * Simple implementation of a {@link MainContract.Presenter} class
 */
public class UndoMainPresenter implements MainContract.Presenter{

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
  private final UndoRemoteControl mRemoteControl;

  UndoMainPresenter(){
    mRemoteControl = new UndoRemoteControl(3);
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
