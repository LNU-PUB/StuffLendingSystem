package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import view.model.Command;
import view.model.MenuOption;

/**
 * Class for mapping commands to menu options.
 * Part of the Command Pattern.
 *
 * @param <T> - The type of the menu option.
 */
public class GenericMenuCommandMapper<T extends MenuOption> {
  private final Map<T, Command> commandMap = new HashMap<>();

  /**
   * Constructor for the mapper.
   *
   * @param enumType - The type of the menu option.
   * @param commands - The list of commands.
   */
  public GenericMenuCommandMapper(Class<T> enumType, List<Command> commands) {
    T[] enumConstants = enumType.getEnumConstants();

    if (enumConstants.length != commands.size()) {
      throw new IllegalArgumentException("Size of commands list must match number of enum constants.");
    }

    for (int i = 0; i < enumConstants.length; i++) {
      commandMap.put(enumConstants[i], commands.get(i));
    }
  }

  /**
   * Returns the command mapped to the given menu option.
   *
   * @param menuOption - The menu option.
   * @return - The command.
   */
  public Command getCommand(T menuOption) {
    return commandMap.get(menuOption);
  }
}
