package com.andrewclam.toyremote.undo.command;

/**
 * Simple Command Interface
 */
public interface Command {
  void execute();
  void undo();
}


