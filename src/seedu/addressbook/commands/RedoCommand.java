package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class RedoCommand extends Command {

    public static final String COMMAND_WORD = "redo";

    public static final String MESSAGE_NO_LAST = "There is no last successful command executed, please use another command.";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Redo last successful command.\n"
            + "Example: " + COMMAND_WORD;
}
