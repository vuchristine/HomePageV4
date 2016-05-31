package vuchris.tacoma.uw.edu.homepagev4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

/**
 * A dialog fragment that takes input and validate them for user to login their account.
 */
public class SignInFragment extends DialogFragment {

    /**
     * Required empty public constructor
     */
    public SignInFragment() {
        // Required empty public constructor
    }

    /**
     * Creates a dialog for user to login their account.
     * @param savedInstanceState
     * @return
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.fragment_sign_in, null))
                // Add action buttons
                .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...

                        //validate the username/email and password
                        /*
                        EditText emailValidate = (EditText)findViewById(R.id.email);
                        EditText userValidate = (EditText)findViewById(R.id.username);
                        EditText passwordValidate = (EditText)findViewById(R.id.password);*/

                        //compare the email/username to the ones in the database
                        //if email/username does not match any of the ones in the database
                        //send an error message
                        //if the password associated with the email/username does not match
                        //send an error message
                        //if the email/username and password match
                        //allow the user to sign into their account
                        Intent homepageIntent = new Intent(getActivity(), HomePageActivity.class);
                        startActivity(homepageIntent);
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
