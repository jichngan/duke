package duke;

import duke.command.Command;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventCommand;
import duke.command.ListCommand;
import duke.command.TodoCommand;
import duke.exception.UnknownInputException;


public class Parser {
    public static final String DONE_COMMAND = "done";
    public static final String LIST_COMMAND = "list";
    public static final String TODO_COMMAND = "todo";
    public static final String EVENT_COMMAND = "event";
    public static final String DEADLINE_COMMAND = "deadline";
    public static final String DELETE_COMMAND = "delete";


    public static Command parse(String userInput) throws UnknownInputException {
        String[] words = userInput.split(" ");
        if (words[0].equals(TODO_COMMAND)) {
            return new TodoCommand(userInput);
        } else if (words[0].equals(EVENT_COMMAND)) {
            return new EventCommand(userInput);
        } else if (words[0].equals(DEADLINE_COMMAND)) {
            return new DeadlineCommand(userInput);
        } else if (words[0].equals(LIST_COMMAND)) {
            return new ListCommand();
        } else if (words[0].equals(DELETE_COMMAND)) {
            return new DeleteCommand(userInput);
        } else if (words[0].equals(DONE_COMMAND)) {
            return new DoneCommand(userInput);
        } else {
            throw new UnknownInputException("There is no such input!");
        }
    }
}