package com.andrewclam.commandpattern;

import android.support.annotation.NonNull;

import com.andrewclam.commandpattern.command.Command;
import com.andrewclam.commandpattern.command.NoCommand;

public class SimpleRemoteControl {
  @NonNull
  private final Command[] onCommands;

  @NonNull
  private final Command[] offCommands;

  private Command undoCommand;

  public SimpleRemoteControl(int numSlots){
    onCommands = new Command[numSlots];
    offCommands = new Command[numSlots];

    // default slots to do nothing with
    Command noCommand = new NoCommand();
    for (int i = 0; i<numSlots; i++){
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }

    // default undo command to do nothing
    undoCommand = noCommand;
  }

  public void setCommand(int slot, Command onCommand, Command offCommand){
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public void onOnButtonClicked(int slot){
    onCommands[slot].execute();
    undoCommand = onCommands[slot];
  }

  public void onOffButtonClicked(int slot){
    offCommands[slot].execute();
    undoCommand = offCommands[slot];
  }

  public void onUndoButtonClicked(){
    undoCommand.undo();
  }
}
