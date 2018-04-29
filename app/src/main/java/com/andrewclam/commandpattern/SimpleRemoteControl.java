package com.andrewclam.commandpattern;

import com.andrewclam.commandpattern.command.Command;

public class SimpleRemoteControl {
  private Command slot;

  public SimpleRemoteControl(){}

  public void setCommand(Command command){
    slot = command;
  }

  public void buttonWasPressed(){
    slot.execute();
  }
}
