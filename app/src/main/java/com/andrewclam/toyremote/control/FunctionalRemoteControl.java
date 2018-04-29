package com.andrewclam.toyremote.control;

import android.support.annotation.NonNull;

import com.andrewclam.toyremote.functional.command.Command;
import com.andrewclam.toyremote.functional.command.NoCommand;

public class FunctionalRemoteControl {
  @NonNull
  private final Command[] onCommands;

  @NonNull
  private final Command[] offCommands;

  public FunctionalRemoteControl(int numSlots){
    onCommands = new Command[numSlots];
    offCommands = new Command[numSlots];

    // default slots to do nothing with
    Command noCommand = new NoCommand();
    for (int i = 0; i<numSlots; i++){
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
  }

  public void setCommand(int slot, Command onCommand, Command offCommand){
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public void onOnButtonClicked(int slot){
    onCommands[slot].execute();
  }

  public void onOffButtonClicked(int slot){
    offCommands[slot].execute();
  }

  public void onUndoButtonClicked(){
    // Not supported
  }
}
