package vuchris.tacoma.uw.edu.homepagev4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Class that stores SQL commands to insert, update, and delete rows.
 */
public class UserCommands {

    //create a DB helper variable
    private DBHelper dbHelper;

    //create constructor for UserCommands
    public UserCommands(Context context) {
        dbHelper = new DBHelper(context);
    }

    /**
     * Insert values.
     * @param user the table
     * @return the user id
     */
    public int insert(User user) {

        //open connection to database
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.EMAIL, user.email);
        values.put(User.USERNAME, user.username);
        values.put(User.PASSWORD, user.password);

        //inserting a row
        long user_id = db.insert(User.TABLE, null, values);

        //close database after inserting
        db.close();

        //return user id
        return (int) user_id;
    }

    /**
     * Update values.
     * @param user the table
     */
    public void update(User user) {

        //open database connection
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        //update score
        values.put(String.valueOf(User.SCORE), user.score);

        //update row
        db.update(User.TABLE, values, User.USER_ID + "= ?", new String[] {String.valueOf(user.user_id)});

        //close database
        db.close();
    }

    /**
     * Delete values.
     * @param user_id the id of the user
     */
    public void delete(int user_id) {

        //open database
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //delete row
        db.delete(User.TABLE, User.USER_ID + "= ?", new String[] {String.valueOf(user_id)});

        //close database
        db.close();
    }
}
