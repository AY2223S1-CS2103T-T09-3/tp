package seedu.address.model.staff;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class StaffContactTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new StaffContact(null));
    }

    @Test
    public void constructor_invalidStaffContact_throwsIllegalArgumentException() {
        String invalidStaffContact = "";
        assertThrows(IllegalArgumentException.class, () -> new StaffContact(invalidStaffContact));
    }

    @Test
    public void isValidStaffContact() {
        // null name
        assertThrows(NullPointerException.class, () -> StaffContact.isValidStaffContact(null));

        // invalid staff contact
        assertFalse(StaffContact.isValidStaffContact("")); // empty string
        assertFalse(StaffContact.isValidStaffContact(" ")); // spaces only
        assertFalse(StaffContact.isValidStaffContact("^")); // only non-alphanumeric characters
        assertFalse(StaffContact.isValidStaffContact("peter*")); // contains non-alphanumeric characters
        assertFalse(StaffContact.isValidStaffContact("peter the 2nd")); // alphanumeric characters
        assertFalse(StaffContact.isValidStaffContact("Capital Tan")); // with capital letters
        assertFalse(StaffContact.isValidStaffContact("David Roger Jackson Ray Jr 2nd")); // long names
        assertFalse(StaffContact.isValidStaffContact("peter jack")); // alphabets only
        assertFalse(StaffContact.isValidStaffContact("912345678")); // 9 numbers beginning with 9
        assertFalse(StaffContact.isValidStaffContact("812345678")); // 9 numbers beginning with 8
        assertFalse(StaffContact.isValidStaffContact("9123456789")); // 7 numbers beginning with 9
        assertFalse(StaffContact.isValidStaffContact("8123456789")); // 7 numbers beginning with 8
        assertFalse(StaffContact.isValidStaffContact("912")); // 3 numbers

        // valid staff contact
        assertTrue(StaffContact.isValidStaffContact("97412345")); // 8 numbers beginning with 9
        assertTrue(StaffContact.isValidStaffContact("87502912")); // 8 numbers beginning with 8

    }
}


