package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.project.Project;
import seedu.address.model.staff.UniqueStaffList;

/**
 * Lists all projects in the address book to the user.
 */
public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays the staff list of the project identified by the index number used.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_SUCCESS = "Listed all Staff members";

    private final Index targetIndex;

    public ViewCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        Project project = model.getFilteredProjectList().get(targetIndex.getZeroBased());
        model.setTargetProject(project);
        UniqueStaffList list = project.getStaffList();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}