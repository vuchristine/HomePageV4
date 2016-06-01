package vuchris.tacoma.uw.edu.homepagev4;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * Class tests the User for validation.
 */
public class UserTest extends TestCase{

    private User mUser;

    @Before
    public void setUp() {
        mUser = new User(21, "fake@mail.com", "FakeUser", "securethis", 43);
    }

    @Test
    public void testSetNegativeUserID() {
        try {
            mUser.setUserID(-4);
            fail("User ID can be set to be less than 0");
        }
        catch (IllegalArgumentException e) {
            //
        }
    }

    @Test
    public void testSetNullEmail() {
        try {
            mUser.setEmail(null);
            fail("Email can be set to null");
        }
        catch (IllegalArgumentException e) {
            //
        }
    }

    @Test
    public void testSetNullUsername() {
        try {
            mUser.setUsername(null);
            fail("Username can be set to null");
        }
        catch (IllegalArgumentException e) {
            //
        }
    }

    @Test
    public void testSetNullPassword() {
        try {
            mUser.setPassword(null);
            fail("Password can be set to null");
        }
        catch (IllegalArgumentException e) {
            //
        }
    }

    @Test
    public void testSetLengthUsername() {
        try {
            mUser.setPassword("ace4");
            fail("Username is less than 6 characters");
        }
        catch (IllegalArgumentException e) {
            //
        }
    }

    @Test
    public void testSetLengthPassword() {
        try {
            mUser.setPassword("1534");
            fail("Password is less than 6 characters");
        }
        catch (IllegalArgumentException e) {
            //
        }
    }

    @Test
    public void testGetUserID() {
        assertEquals(564, mUser.getUserID());
    }

    @Test
    public void testGetEmail() {
        assertEquals("joiboy1868@email.com", mUser.getEmail());
    }

    @Test
    public void testGetUsername() {
        assertEquals("KrystalKlear", mUser.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("0Na5in3Dai", mUser.getPassword());
    }

    @Test
    public  void testConstructor() {
        User User = new User(34, "LoversBlame@email.com", "Cl0udyDay", "TCSS360", 69);
        assertNotNull(User);
    }
}
