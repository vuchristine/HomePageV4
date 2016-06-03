package vuchris.tacoma.uw.edu.homepagev4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Class creates or deletes the table.
 */
public class UserDB {

    //version number
    public static final int DATABASE_VERSION = 1;

    //database name
    public static final String DATABASE_NAME = "User.db";

    //table name
    private static final String USER_TABLE = "User";

    //variables for DB helper and SQLite database
    private UserDBHelper mUserDBHelper;
    private SQLiteDatabase mSQLiteDatabase;

    //create a constructor for DB helper
    public UserDB(Context context) {

        //create new DB helper
        mUserDBHelper = new UserDBHelper(context, DATABASE_NAME, null, DATABASE_VERSION);

        //allow database to be writeen
        mSQLiteDatabase = mUserDBHelper.getWritableDatabase();
    }

    /**
     * DB Helper create and drop tables when needed.
     */
    class UserDBHelper extends SQLiteOpenHelper {

        //create user table
        private final String CREATE_USER_SQL;

        //drop user table
        private final String DROP_USER_SQL;

        /**
         * Contains variables for creating and dropping tables.
         * @param context context
         * @param name name of string
         * @param factory cursor factory
         * @param version the databas's version
         */
        public UserDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);

            //create user table
            CREATE_USER_SQL = context.getString(R.string.CREATE_USER_SQL);

            //drop user table
            DROP_USER_SQL = "DROP TABLE IF EXISTS User";
        }

        /**
         * Create table if it doesn't exist.
         * @param db the database where the table is to be created in
         */
        @Override
        public void onCreate(SQLiteDatabase db) {

            //create table
            db.execSQL(CREATE_USER_SQL);
        }

        /**
         * Drop table if it does exist.
         * @param db the database where the table is located at to be dropped
         * @param oldVersion old version of the database
         * @param newVersion new version of the database
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            //drop table
            db.execSQL(DROP_USER_SQL);

            //recreate table
            onCreate(db);
        }
    }

    /**
     * Insert a new row into the sqlite table.
     * @param user User table
     * @return true if insert is successful, false otherwise
     */
    public boolean insertUser(User user) {

        //open connection
        SQLiteDatabase db = mUserDBHelper.getWritableDatabase();

        //get new content values
        ContentValues contentValues = new ContentValues();

        //insert these new values
        contentValues.put(User.USERID, user.userID);
        contentValues.put(User.EMAIL, user.email);
        contentValues.put(User.USERNAME, user.username);
        contentValues.put(User.PASSWORD, user.password);
        contentValues.put(String.valueOf(User.SCORE), user.score);

        //create user id
        long userID = mSQLiteDatabase.insert(User.TABLE, null, contentValues);

        //close connection
        db.close();

        //return true
        return userID != -1;
    }

    /**
     * Delete all rows from USER TABLE.
     */
    public void deleteUsers() {

        mSQLiteDatabase.delete(USER_TABLE, null, null);
    }

    /**
     * Close the database.
     */
    public void closeDB() {

        mSQLiteDatabase.close();
    }
}
