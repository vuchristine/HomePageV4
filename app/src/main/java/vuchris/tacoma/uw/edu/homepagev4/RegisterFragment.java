package vuchris.tacoma.uw.edu.homepagev4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * A dialog fragment that takes in input and validate them to add to database.
 */
public class RegisterFragment extends DialogFragment {

    private final static String COURSE_ADD_URL = "http://cssgate.insttech.washington.edu/~vuchris/addCourse.php?";

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Creates a dialog for user to register an account.
     * @param savedInstanceState
     * @return the alert dialog builder
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //build alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.fragment_register, container, false);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.fragment_register, null))
                // Add action buttons
                .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        EditText emailValidate = (EditText)findViewById(R.id.email);
                        EditText userValidate = (EditText)findViewById(R.id.username);
                        EditText passwordValidate = (EditText)findViewById(R.id.password);
                        EditText confirmValidate = (EditText)findViewById(R.id.confirm);

                        //string for helping validate email
                        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                        // sign in the user ...
                        //if email is empty
                        if (emailValidate == null) {
                            //send an error message
                        }
                        //if email is invalid
                        else if (emailValidate.getEditableText().length() < 0) {
                            //
                        }
                        //if password or confirm password is empty
                        else if (passwordValidate == null || confirmValidate == null) {
                            //send an error message
                        }
                        //if password or confirm password is less than 8 character
                        else if (passwordValidate.getEditableText().length() < 0 || confirmValidate.getEditableText().length() < 0) {
                            //send an error message
                        }
                        //if password and confirm password do not match
                        else if (passwordValidate.getText().toString().compareTo(confirmValidate.getText().toString()) != 0) {
                            //send error message
                        }
                        //if everything is valid
                        else {
                            //add the email
                            //add the user
                            //add the password

                            //insert a new row into the table User
                            insert = UserCommands.insert(emailValidate, userValidate, passwordValidate);
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dismiss();
                    }
                });
        return builder.create();
    }
}

