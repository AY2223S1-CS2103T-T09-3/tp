package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_PROJECT;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_STAFF;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STAFFCONTACT_JAY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STAFFNAME_ANDY;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalAddressBook.getTypicalAddressBook;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PROJECT;
import static seedu.address.testutil.TypicalStaff.STAFF_ANDY;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.project.Project;
import seedu.address.model.project.ProjectName;
import seedu.address.model.staff.Staff;
import seedu.address.model.staff.StaffName;
import seedu.address.testutil.StaffBuilder;

public class DeleteStaffCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validInput_success() {
        cleanUpModel();
        Project project = model.getFilteredProjectList().get(INDEX_FIRST_PROJECT.getZeroBased());
        Staff staff = new StaffBuilder(STAFF_ANDY).build();
        StaffName staffName = staff.getStaffName();
        DeleteStaffCommand deleteStaffCommand = new DeleteStaffCommand(staffName, project.getProjectName());

        String expectedMessage = String.format(DeleteStaffCommand.MESSAGE_DELETE_STAFF_SUCCESS,
                staff.getStaffName().staffName);

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        model.getFilteredProjectList().get(INDEX_FIRST_PROJECT.getZeroBased()).getStaffList().add(staff);

        assertCommandSuccess(deleteStaffCommand, model, expectedMessage, expectedModel);
    }

    //Test to check that command throw exception when trying to delete a staff not in project
    @Test
    public void execute_invalidStaff_throwCommandException() {
        cleanUpModel();
        StaffName staffName = new StaffName(VALID_NAME_AMY);
        Project project = model.getFilteredProjectList().get(INDEX_FIRST_PROJECT.getZeroBased());
        ProjectName projectName = project.getProjectName();
        DeleteStaffCommand deleteStaffCommand = new DeleteStaffCommand(staffName, projectName);

        String expectedMessage = String.format(MESSAGE_INVALID_STAFF, staffName);

        assertCommandFailure(deleteStaffCommand, model, expectedMessage);
    }

    //Test to check that command throw exception when trying to
    //delete a staff from project not inside HR Pro Max++
    @Test
    public void execute_invalidProject_throwCommandException() {
        cleanUpModel();
        Staff staff = new StaffBuilder(STAFF_ANDY).build();
        StaffName staffName = staff.getStaffName();
        ProjectName projectName = new ProjectName(VALID_NAME_BOB);
        DeleteStaffCommand deleteStaffCommand = new DeleteStaffCommand(staffName, projectName);

        String expectedMessage = String.format(MESSAGE_INVALID_PROJECT, projectName);

        assertCommandFailure(deleteStaffCommand, model, expectedMessage);
    }

    @Test
    public void equals() {
        cleanUpModel();
        StaffName staffNameFirst = new StaffName(VALID_STAFFNAME_ANDY);
        StaffName staffNameSecond = new StaffName(VALID_STAFFCONTACT_JAY);
        ProjectName projectNameFirst = new ProjectName(VALID_NAME_AMY);
        ProjectName projectNameSecond = new ProjectName(VALID_NAME_BOB);
        DeleteStaffCommand deleteFirstCommand = new DeleteStaffCommand(staffNameFirst, projectNameFirst);
        DeleteStaffCommand deleteSecondCommand = new DeleteStaffCommand(staffNameSecond, projectNameSecond);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        DeleteStaffCommand deleteFirstCommandCopy = new DeleteStaffCommand(staffNameFirst, projectNameFirst);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different project -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }

    private void cleanUpModel() {
        Project project = model.getFilteredProjectList().get(INDEX_FIRST_PROJECT.getZeroBased());
        project.getStaffList().setStaffs(new ArrayList<>());
    }
}
