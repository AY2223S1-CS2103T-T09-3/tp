package seedu.hrpro.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.hrpro.model.project.Project;
import seedu.hrpro.model.project.UniqueProjectList;
import seedu.hrpro.model.staff.Staff;
import seedu.hrpro.model.staff.UniqueStaffList;
import seedu.hrpro.model.task.Task;
import seedu.hrpro.model.task.UniqueTaskList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSameProject comparison)
 */
public class HRPro implements ReadOnlyHRPro {

    private final UniqueProjectList projects;
    private final UniqueStaffList staff;
    private final UniqueTaskList tasks;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        projects = new UniqueProjectList();
    }

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        staff = new UniqueStaffList();
    }

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        tasks = new UniqueTaskList();
    }

    public HRPro() {}

    /**
     * Creates an HRPro using the Projects in the {@code toBeCopied}
     */
    public HRPro(ReadOnlyHRPro toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the project list with {@code projects}.
     * {@code projects} must not contain duplicate projects.
     */
    public void setProjects(List<Project> projects) {
        this.projects.setProjects(projects);
    }

    /**
     * Replaces the contents of the staff list with {@code staff}.
     * {@code staff} must not contain duplicate staff.
     */
    public void setStaffList(UniqueStaffList staff) {
        this.staff.setStaffs(staff);
    }

    /**
     * Replaces the contents of the staff list with {@code staff}.
     * {@code staff} must not contain duplicate staff.
     */
    public void setStaffList(List<Staff> staff) {
        this.staff.setStaffs(staff);
    }

    /**
     * Replaces the contents of the task list with {@code tasks}.
     * {@code tasks} must not contain duplicate tasks.
     */
    public void setTasks(List<Task> tasks) {
        this.tasks.setTasks(tasks);
    }

    /**
     * Resets the existing data of this {@code HRPro} with {@code newData}.
     */
    public void resetData(ReadOnlyHRPro newData) {
        requireNonNull(newData);

        setProjects(newData.getProjectList());
        setStaffList(newData.getStaffList());
        setTasks(newData.getTaskList());
    }

    //// project-level operations

    /**
     * Returns true if a project with the same identity as {@code project} exists in hr pro.
     */
    public boolean hasProject(Project project) {
        requireNonNull(project);
        return projects.contains(project);
    }

    /**
     * Adds a project to hr pro.
     * The project must not already exist in hr pro.
     */
    public void addProject(Project p) {
        projects.add(p);
    }

    /**
     * Replaces the given project {@code target} in the list with {@code editedProject}.
     * {@code target} must exist in hr pro.
     * The project identity of {@code editedProject} must not be the same as another
     * existing project in hr pro.
     */
    public void setProject(Project target, Project editedProject) {
        requireNonNull(editedProject);

        projects.setProject(target, editedProject);
    }

    /**
     * Removes {@code key} from this {@code HRPro}.
     * {@code key} must exist in hr pro.
     */
    public void removeProject(Project key) {
        projects.remove(key);
    }

    /**
     * Sorts the projects according to deadline.
     */
    public void sortProjects() {
        projects.sortProjects();
    }

    //// staff-level operations

    /**
     * Returns true if a staff with the same identity as {@code staff} exists in hr pro.
     */
    public boolean hasStaff(Staff staff) {
        requireNonNull(staff);
        return this.staff.contains(staff);
    }

    /**
     * Adds a staff to hr pro.
     * The staff must not already exist in hr pro.
     */
    public void addStaff(Staff p) {
        this.staff.add(p);
    }

    //// task-level operations

    /**
     * Returns true if a task with the same identity as {@code task} exists in hr pro.
     */
    public boolean hasTask(Task task) {
        requireNonNull(task);
        return tasks.contains(task);
    }

    /**
     * Adds a task to hr pro.
     * The task must not already exist in hr pro.
     */
    public void addTask(Task t) {
        tasks.add(t);
    }

    /**
     * Replaces the given task {@code target} in the list with {@code editedTask}.
     * {@code target} must exist in hr pro.
     * The project identity of {@code editedTask} must not be the same as another
     * existing task in hr pro.
     */
    public void setTask(Task target, Task editedTask) {
        requireNonNull(editedTask);

        tasks.setTask(target, editedTask);
    }

    /**
     * Removes {@code key} from this {@code HRPro}.
     * {@code key} must exist in hr pro.
     */
    public void removeTask(Task key) {
        tasks.remove(key);
    }

    public void sortComplete() {
        tasks.sortComplete();
    }

    /**
     * Sorts the projects according to deadline.
     */
    public void sortTasks() {
        tasks.sortTasks();
    }

    //// util methods

    @Override
    public String toString() {
        return projects.asUnmodifiableObservableList().size() + " projects, "
                + tasks.asUnmodifiableObservableList().size() + " tasks";
        // TODO: refine later
    }

    @Override
    public ObservableList<Project> getProjectList() {
        return projects.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Staff> getStaffList() {
        return staff.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Task> getTaskList() {
        return tasks.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof HRPro // instanceof handles nulls
                && projects.equals(((HRPro) other).projects)
                && staff.equals(((HRPro) other).staff)
                && tasks.equals(((HRPro) other).tasks));
    }

    @Override
    public int hashCode() {
        return projects.hashCode();
    }
}
