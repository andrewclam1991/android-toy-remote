package com.andrewclam.toyremote.functional.command;

/**
 * Functional interface version of {@link com.andrewclam.toyremote.undo.command.Command}
 * This is advantageous in reducing number of concrete impl of {@link Command}
 * however, implementing undo may not be trivial
 */
public interface Command {
  void execute();
}
