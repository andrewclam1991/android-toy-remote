package com.andrewclam.commandpattern;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.andrewclam.commandpattern.command.Command;
import com.andrewclam.commandpattern.command.GarageDoorOpenCommand;
import com.andrewclam.commandpattern.command.LightOffCommand;
import com.andrewclam.commandpattern.command.LightOnCommand;
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
    mRemoteControl = new SimpleRemoteControl();
    // Create "garage door open" command
    GarageDoor garageDoor = new GarageDoorImpl();
    Command garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
    mRemoteControl.setCommand(garageDoorOpenCommand);
  }

  @Override
  public void onLightOnButtonClicked() {
    // Create "light on" command
    Light light = new LightImpl();
    Command lightOnCommand = new LightOnCommand(light);
    mRemoteControl.setCommand(lightOnCommand);
    mRemoteControl.buttonWasPressed();
    if (mView != null) mView.showResultMsg("light on, see log for impl");
  }

  @Override
  public void onLightOffButtonClicked() {
    // Create "light off" command
    Light light = new LightImpl();
    Command lightOffCommand = new LightOffCommand(light);
    mRemoteControl.setCommand(lightOffCommand);
    mRemoteControl.buttonWasPressed();
    if (mView != null) mView.showResultMsg("light off, see log for impl");
  }

}
