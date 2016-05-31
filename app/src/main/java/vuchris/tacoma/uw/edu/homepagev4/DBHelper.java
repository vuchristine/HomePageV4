package vuchris.tacoma.uw.edu.homepagev4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Class creates or deletes the table.
 */
public class DBHelper extends SQLiteOpenHelper {

    //version number
    public static final int DATABASE_VERSION = 4;

    //database name
    public static final String DATABASE_NAME = "user.db";

    //create a constructor for DB helper
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Create table for registering accounts.
     * @param db database to store email, username, password, and score
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        //create table with user id, email, username, password, and score
        String CREATE_USER_TABLE = "CREATE TABLE" + User.TABLE + "("
                + User.USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + User.EMAIL + " TEXT, "
                + User.USERNAME + " TEXT, "
                + User.PASSWORD + " TEXT, "
                + User.SCORE + " INTEGER )";

        //execute create table command
        db.execSQL(CREATE_USER_TABLE);
    }

    /**
     * Upgrade table by deleting table if existed and recreating it.
     * @param db database
     * @param oldVersion old version of the table
     * @param newVersion new version of the table
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //drop older table if it existed
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE);

        //create table again
        onCreate(db);
    }
}
