package com.andrewclam.toyremote.data.models;

import android.util.Log;

import com.andrewclam.toyremote.data.vendorapi.GarageDoor;

public class GarageDoorImpl implements GarageDoor {
  @Override
  public void up() {
    Log.d("GarageDoor", "GarageDoor is opened");
  }

  @Override
  public void down() {
    Log.d("GarageDoor", "GarageDoor is closed");
  }

  @Override
  public void stop() {
    Log.d("GarageDoor", "GarageDoor operation stopped");
  }

  @Override
  public void lightOn() {
    Log.d("GarageDoor", "GarageDoor light is on ");
  }

  @Override
  public void lightOff() {
    Log.d("GarageDoor", "GarageDoor light is off ");
  }
}
