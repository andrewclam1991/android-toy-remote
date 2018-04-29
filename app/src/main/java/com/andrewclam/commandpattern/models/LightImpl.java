package com.andrewclam.commandpattern.models;

import android.util.Log;

import com.andrewclam.commandpattern.vendorapi.Light;

public class LightImpl implements Light {
  @Override
  public void on() {
    Log.d("Light", "Light is on");
  }

  @Override
  public void off() {
    Log.d("Light", "Light is off");
  }
}
