package com.andrewclam.toyremote.undo.command;

import com.andrewclam.toyremote.data.vendorapi.GarageDoor;

/**
 * Concrete implementation of a {@link Command}
 * that has-a {@link GarageDoor} to command
 */
public class GarageDoorOpenCommand implements Command {

  private GarageDoor garageDoor;

  public GarageDoorOpenCommand(GarageDoor garageDoor){
    this.garageDoor = garageDoor;
  }

  @Override
  public void execute() {
    garageDoor.up();
  }

  @Override
  public void undo() {
    garageDoor.down();
  }
}
