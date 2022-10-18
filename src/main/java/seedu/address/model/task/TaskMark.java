package seedu.address.model.task;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class TaskMark {
    public static final String MESSAGE_CONSTRAINTS =
            "Task can only be marked as true for completed or false for not completed";

    /**
     * Accepts only true or false as valid input.
     */
    public static final String VALIDATION_REGEX = "(true|false)";

    public final String taskMark;

    public TaskMark(String taskMark) {
        requireNonNull(taskMark);
        checkArgument(isValidTaskMark(taskMark), MESSAGE_CONSTRAINTS);
        this.taskMark = taskMark;
    }

    /**
     * Checks if it is a valid TaskMark.
     * @param test String to check if its a valid TaskMark
     * @return True if its either true or false.
     */
    public static boolean isValidTaskMark(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return taskMark;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof TaskMark)
                && taskMark.equals(((TaskMark) other).taskMark);
    }

    @Override
    public int hashCode() {
        return taskMark.hashCode();
    }
}
