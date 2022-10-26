package seedu.address.model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.index.Index;
import seedu.address.model.project.Project;
import seedu.address.model.staff.Staff;
import seedu.address.model.task.Task;

/**
 * The API of the Model component.
 */
public interface Model {
    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<Project> PREDICATE_SHOW_ALL_PROJECTS = unused -> true;

    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<Staff> PREDICATE_SHOW_ALL_STAFF = unused -> true;

    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<Task> PREDICATE_SHOW_ALL_TASKS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /**
     * Returns the AddressBook
     */
    ReadOnlyAddressBook getAddressBook();

    //=========== Projects ================================================================================

    /**
     * Returns true if a project with the same identity as {@code project} exists in the address book.
     */
    boolean hasProject(Project project);

    /**
     * Deletes the given project.
     * The project must exist in the address book.
     */
    void deleteProject(Project target);

    /**
     * Sorts the project list.
     */
    void sortProjects();

    /**
     * Adds the given project.
     * {@code project} must not already exist in the address book.
     */
    void addProject(Project project);

    /**
     * Replaces the given project {@code target} with {@code editedProject}.
     * {@code target} must exist in the address book.
     * The project identity of {@code editedProject} must not be the same as
     * another existing project in the address book.
     */
    void setProject(Project target, Project editedProject);

    /**
     * Updates the filter of the filtered project list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredProjectList(Predicate<Project> predicate);

    /**
     * Returns an unmodifiable view of the filtered project list
     */
    ObservableList<Project> getFilteredProjectList();

    //=========== Staff ================================================================================

    /**
     * Returns an unmodifiable view of the filtered staff list
     */
    ObservableList<Staff> getFilteredStaffList();

    /**
     * Updates the filter of the filtered staff list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredStaffList(Predicate<Staff> predicate);

    /** Sets filtered Staff list to be the staff list of {@code project} specified by the view command */
    void setFilteredStaffList(Project project);

    /**
     * Returns true if a staff with the same identity as {@code staff} exists in the address book.
     */
    boolean hasStaff(Staff staff);

    /**
     * Deletes the given staff.
     * The staff must exist in the address book.
     */
    void deleteStaff(Staff target);

    /**
     * Adds the given staff.
     * {@code staff} must not already exist in the address book.
     */
    void addStaff(Staff staff);

    /**
     * Replaces the given staff {@code target} with {@code editedStaff}.
     * {@code target} must exist in the address book.
     * The staff identity of {@code editedStaff} must not be the same as
     * another existing staff in the address book.
     */
    void setStaff(Staff target, Staff editedStaff);

    //=========== Tasks ================================================================================
    /**
     * Returns true if a task with the same identity as {@code task} exists in the address book.
     */
    boolean hasTask(Task task);

    /**
     * Deletes the given task.
     * The task must exist in the address book.
     */
    void deleteTask(Task target);

    /**
     * Adds the given task.
     * {@code task} must not already exist in the address book.
     */
    void addTask(Task task);

    /**
     * Replaces the given task {@code target} with {@code editedTask}.
     * {@code target} must exist in the address book.
     * The task identity of {@code editedTask} must not be the same as
     * another existing task in the address book.
     */
    void setTask(Task target, Task editedTask);

    /** Sets the given task to be the target of the view command */
    void setTargetTask(Task target);

    /** Returns the task that is the target of the view command */
    ArrayList<Task> getTargetTask();

    /**
     * Returns an unmodifiable view of the filtered task list
     */
    ObservableList<Task> getFilteredTaskList();

    /**
     * Updates the filter of the filtered task list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredTaskList(Predicate<Task> predicate);

    /**
     * Updates the tasks to show the uncompleted tasks at the top and the rest at the bottom.
     */
    void filterTask();

    /**
     * Update the task of the filtered task list to set it to be a completed task.
     *
     * @param targetIndex The index of the task in the filtered task list.
     */
    void markTask(Index targetIndex);

    /**
     * Update the task of the filtered task list to set it to be a uncompleted task.
     *
     * @param targetIndex The index of the task in the filtered task list.
     */
    void unmarkTask(Index targetIndex);

    /**
     * Sorts the task list.
     */
    void sortTasks();

}
