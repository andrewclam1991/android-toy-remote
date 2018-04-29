package com.andrewclam.commandpattern.undo.command;

import com.andrewclam.commandpattern.data.vendorapi.Light;

/**
 * Concrete implementation of a {@link Command}
 * that has-a {@link Light} to command
 */
public class LightOnCommand implements Command {

  private Light light;

  public LightOnCommand(Light light){
    this.light = light;
  }

  @Override
  public void execute() {
    light.on();
  }

  @Override
  public void undo() {
    light.off();
  }
}
