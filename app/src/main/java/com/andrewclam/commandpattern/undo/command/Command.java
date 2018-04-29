package com.andrewclam.commandpattern.undo.command;

/**
 * Simple Command Interface
 */
public interface Command {
  void execute();
  void undo();
}


