package com.andrewclam.commandpattern.control;

import android.support.annotation.NonNull;

import com.andrewclam.commandpattern.undo.command.Command;
import com.andrewclam.commandpattern.undo.command.NoCommand;

public class UndoRemoteControl {
  @NonNull
  private final Command[] onCommands;

  @NonNull
  private final Command[] offCommands;

  private Command undoCommand;

  public UndoRemoteControl(int numSlots){
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
