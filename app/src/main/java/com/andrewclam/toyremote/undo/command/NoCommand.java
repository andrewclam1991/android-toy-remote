package com.andrewclam.toyremote.undo.command;

public class NoCommand implements Command {
  @Override
  public void execute() {
    // do nothing
  }

  @Override
  public void undo() {
    // do nothing
  }
}
