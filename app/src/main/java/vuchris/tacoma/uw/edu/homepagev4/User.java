package vuchris.tacoma.uw.edu.homepagev4;

/**
 * Class storing the table, column values.
 */
public class User {

    //table name
    public static final String TABLE = "Users";

    //column names
    public static final int USER_ID = 0;
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final int SCORE = 0;

    //variables to keep data
    public int user_id;
    public String email;
    public String username;
    public String password;
    public int score;
}
