package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class SortCommand extends Command {
    
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_SUCCESS = "Projects are now sorted!";
    
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.sortProjects();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
