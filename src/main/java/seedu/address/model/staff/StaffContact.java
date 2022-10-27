package seedu.address.model.staff;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a staff contact in HR Pro Max++.
 * Guarantees: immutable; is valid as declared in {@link #isValidStaffContact(String)}
 */
public class StaffContact {
    public static final String MESSAGE_CONSTRAINTS =
            "Staff contact should only contain numbers and at least 3 digits .Also it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "\\d{3,}";

    public final String staffContact;

    /**
     * Constructs a {@code Name}.
     *
     * @param contact A valid name.
     */
    public StaffContact(String contact) {
        requireNonNull(contact);
        checkArgument(isValidStaffContact(contact), MESSAGE_CONSTRAINTS);
        staffContact = contact;
    }

    /**
     * Returns true if a given string is a valid staff contact.
     */
    public static boolean isValidStaffContact(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return staffContact;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StaffContact // instanceof handles nulls
                && staffContact.equals(((StaffContact) other).staffContact)); // state check
    }

    @Override
    public int hashCode() {
        return staffContact.hashCode();
    }
}
