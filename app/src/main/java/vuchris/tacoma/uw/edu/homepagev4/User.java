package vuchris.tacoma.uw.edu.homepagev4;

/**
 * Class storing the table, column values.
 */
public class User {

    //table name
    public static final String TABLE = "Users";

    //column names
    public static final String USERID = "id";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final int SCORE = 0;

    //variables to keep data
    public String userID;
    public String email;
    public String username;
    public String password;
    public int score;

    /**
     * Get these values.
     * @param userID unique ID for each user
     * @param email user's email
     * @param username user's chosen display name
     * @param password user's password
     * @param score user's score
     */
    public User(String userID, String email, String username, String password, int score) {
        this.userID = userID;
        this.email = email;
        this.username = username;
        this.password = password;
        this.score = score;
    }

    /**
     * Get the user id.
     * @return user id
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Set the user's id.
     * @param userID unique id assigned to each user
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Get the user's email.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user's email.
     * @param email the user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the user's username.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the user's username.
     * @param username a name chosen by the user to display online
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the user's password.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user's password.
     * @param password the user's password to secure their account
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the user's score.
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the user's score.
     * @param score the score awarded to the user after playing the game
     */
    public void setScore(int score) {
        this.score = score;
    }
}
