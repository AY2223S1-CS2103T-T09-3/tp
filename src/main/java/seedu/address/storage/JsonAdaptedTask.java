package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskDeadline;
import seedu.address.model.task.TaskDescription;
import seedu.address.model.task.TaskMark;

/**
 * Jackson-friendly version of {@link Task}.
 */
public class JsonAdaptedTask {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Task's %s field is missing!";

    private final String taskDeadline;
    private final String taskDescription;
    private final String taskMark;

    /**
     * Constructs a {@code JsonAdaptedTask} with the given task details.
     */
    @JsonCreator
    public JsonAdaptedTask(@JsonProperty("taskDeadline") String taskDeadline,
                            @JsonProperty("taskDescription") String taskDescription,
                           @JsonProperty("taskMark") String taskMark) {
        this.taskDeadline = taskDeadline;
        this.taskDescription = taskDescription;
        this.taskMark = taskMark;
    }

    /**
     * Converts a given {@code Task} into this class for Jackson use.
     */
    public JsonAdaptedTask(Task source) {
        taskDeadline = source.getTaskDeadline().taskDeadLine;
        taskDescription = source.getTaskDescription().taskDescription;
        taskMark = source.getTaskMark().taskMark;
    }

    /**
     * Converts this Jackson-friendly adapted task object into the model's {@code Task} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted task.
     */
    public Task toModelType() throws IllegalValueException {
        if (taskDeadline == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    TaskDeadline.class.getSimpleName()));
        }
        if (!TaskDeadline.isValidTaskDeadline(taskDeadline)) {
            throw new IllegalValueException(TaskDeadline.MESSAGE_CONSTRAINTS);
        }
        final TaskDeadline modelTaskDeadline = new TaskDeadline(taskDeadline);

        if (taskDescription == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    TaskDescription.class.getSimpleName()));
        }
        if (!TaskDescription.isValidTaskDescription(taskDescription)) {
            throw new IllegalValueException(TaskDescription.MESSAGE_CONSTRAINTS);
        }
        final TaskDescription modelTaskDescription = new TaskDescription(taskDescription);

        if (taskMark == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    TaskMark.class.getSimpleName()));
        }
        if (!TaskMark.isValidTaskMark(taskMark)) {
            throw new IllegalValueException(TaskMark.MESSAGE_CONSTRAINTS);
        }
        final TaskMark modelTaskMark = new TaskMark(taskMark);

        return new Task(modelTaskDeadline, modelTaskDescription, modelTaskMark);
    }

}
