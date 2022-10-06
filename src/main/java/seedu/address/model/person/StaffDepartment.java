package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class StaffDepartment {
    public static final String MESSAGE_CONSTRAINTS =
            "Names should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String staffDepartment;

    /**
     * Constructs a {@code Name}.
     *
     * @param department A valid department name.
     */
    public StaffDepartment(String department) {
        requireNonNull(department);
        checkArgument(isValidName(department), MESSAGE_CONSTRAINTS);
        staffDepartment = department;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidName(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return staffDepartment;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StaffDepartment // instanceof handles nulls
                && staffDepartment.equals(((StaffDepartment) other).staffDepartment)); // state check
    }

    @Override
    public int hashCode() {
        return staffDepartment.hashCode();
    }
}
