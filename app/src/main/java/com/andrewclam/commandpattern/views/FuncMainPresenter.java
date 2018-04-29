package com.andrewclam.commandpattern.views;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.andrewclam.commandpattern.control.FunctionalRemoteControl;
import com.andrewclam.commandpattern.data.models.GarageDoorImpl;
import com.andrewclam.commandpattern.data.models.LightImpl;
import com.andrewclam.commandpattern.data.vendorapi.GarageDoor;
import com.andrewclam.commandpattern.data.vendorapi.Light;

/**
 * Simple implementation of a {@link MainContract.Presenter} class
 */
public class FuncMainPresenter implements MainContract.Presenter {

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
  private final FunctionalRemoteControl mRemoteControl;

  FuncMainPresenter() {
    mRemoteControl = new FunctionalRemoteControl(3);
    setupRemoteControl();
  }

  private void setupRemoteControl() {
    // Create "light on" and "light off" command
    // Create the receiver
    Light light = new LightImpl();
    mRemoteControl.setCommand(0, light::on, light::off);

    // Create "garage open" and "garage close" command
    GarageDoor garageDoor = new GarageDoorImpl();
    mRemoteControl.setCommand(1, garageDoor::up, garageDoor::down);
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
