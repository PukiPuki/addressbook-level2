package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static seedu.addressbook.common.Messages.*;

/**
 * Text UI of the application.
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    private final Scanner in;
    private final PrintStream out;

    public Formatter(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    static String formatLinePrefix(String afterLinePrefix) {
        return LINE_PREFIX.concat(afterLinePrefix);
    }

    static String formatCommandEntered(String fullInputLine) {
       return tidyUp("[Command entered:" + fullInputLine + "]");
    }

    static String formatWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return tidyUp(
                DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER);
    }

    static String formatMessage(String message) {
        return tidyUp(message, DIVIDER, DIVIDER);
    }

    /** Formats messages */
    static String tidyUp(String... message) {
        StringBuilder formatted = new StringBuilder();
        for (String m : message) {
            formatted.append(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX) + "\n");
        }
        return formatted.toString();
    }

    static String formatResultToUser(CommandResult result) {
        return tidyUp(result.feedbackToUser, DIVIDER);
    }

    /** Formats a list of strings to the user, formatted as an indexed list. */
    static String formatToUserAsIndexedList(List<String> list) {
        return tidyUp(getIndexedListForViewing(list));
    }

    /** Formats a list of strings as a viewable indexed list. */
    private static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
