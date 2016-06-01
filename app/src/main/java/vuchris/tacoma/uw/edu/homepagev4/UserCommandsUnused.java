package vuchris.tacoma.uw.edu.homepagev4;

import android.content.ContentValues;
import android.content.Context;

/**
 * Class that stores SQL commands to insert, update, and delete rows.
 */
public class UserCommandsUnused {

    //create a DB helper variable
    private UserDB userDb;

    //create constructor for UserCommands
    public UserCommandsUnused(Context context) {
        userDb = new UserDB(context);
    }

    /**
     * Insert values.
     * @param user the table
     * @return the user id
     */
    public int insert(User user) {

        //open connection to database
        //SQLiteDatabase db = userDb.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.EMAIL, user.email);
        values.put(User.USERNAME, user.username);
        values.put(User.PASSWORD, user.password);

        //inserting a row
        //long USERID = db.insert(User.TABLE, null, values);

        //close database after inserting
        //db.close();

        //return user id
        //return (int) USERID;
        return 0;
    }

    /**
     * Update values.
     * @param user the table
     */
    public void update(User user) {

        //open database connection
        //SQLiteDatabase db = userDb.getWritableDatabase();
        ContentValues values = new ContentValues();

        //update score
        values.put(String.valueOf(User.SCORE), user.score);

        //update row
        //db.update(User.TABLE, values, User.USERID + "= ?", new String[] {String.valueOf(user.USERID)});

        //close database
        //db.close();
    }

    /**
     * Delete values.
     * @param USERID the id of the user
     */
    public void delete(int USERID) {

        //open database
        //SQLiteDatabase db = userDb.getWritableDatabase();

        //delete row
        //db.delete(User.TABLE, User.USERID + "= ?", new String[] {String.valueOf(USERID)});

        //close database
        //db.close();
    }
}
