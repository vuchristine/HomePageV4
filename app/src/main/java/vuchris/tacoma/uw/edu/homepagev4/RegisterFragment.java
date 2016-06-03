package vuchris.tacoma.uw.edu.homepagev4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A dialog fragment that takes in input and validate them to add to database.
 */
public class RegisterFragment extends DialogFragment {

    private EditText emailValidate;
    private EditText userValidate;
    private EditText passwordValidate;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Creates a dialog for user to register an account.
     * @param savedInstanceState the state of the dialog
     * @return the alert dialog builder
     */
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //build alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_register, null);
        //builder.setView(view);

        //final edit text variables
        final EditText emailText = (EditText)view.findViewById(R.id.email);
        final EditText userText = (EditText)view.findViewById(R.id.username);
        final EditText passwordText = (EditText)view.findViewById(R.id.password);

        // Inflate and set the layout for the diailog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view/*inflater.inflate(R.layout.fragment_register, null)*/)
                // Add action buttons
                .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        //string variables for edit texts
                        String email = emailText.getText().toString();
                        String username = userText.getText().toString();
                        String password = passwordText.getText().toString();

                        //string for helping validate email
                        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                        //if email is empty
                        if (TextUtils.isEmpty(email)) {

                            //error message
                            Toast.makeText(view.getContext(), "Please enter email."
                                    , Toast.LENGTH_SHORT)
                                    .show();

                            emailText.requestFocus();

                            return;
                        }
                        //if email does not contain @
                        else if (!email.contains("@")) {

                            //show error message
                            Toast.makeText(view.getContext(), "Please enter a valid email address."
                                    , Toast.LENGTH_SHORT)
                                    .show();

                            emailText.requestFocus();

                            return;
                        }
                        //if username is empty
                        else if (TextUtils.isEmpty(username))  {

                            //show error message
                            Toast.makeText(view.getContext(), "Please enter username."
                                    , Toast.LENGTH_SHORT)
                                    .show();

                            userText.requestFocus();

                            return;
                        }
                        //if password is empty
                        else if (TextUtils.isEmpty(password))  {

                            //show error message
                            Toast.makeText(view.getContext(), "Please enter password."
                                    , Toast.LENGTH_SHORT)
                                    .show();

                            passwordText.requestFocus();

                            return;
                        }
                        //if password length is less than 6 characters
                        else if (password.length() < 6) {

                            //show error message
                            Toast.makeText(view.getContext(), "Enter password of at least 6 " +
                                            "characters."
                                    , Toast.LENGTH_SHORT)
                                    .show();

                            passwordText.requestFocus();

                            return;
                        }
                        else {

                            //enter all of the valid data into database
                            User user = new User(null, email, username, password, 0);

                            //sign into app
                            //((LoginActivity)getActivity()).launch(v);
                            Intent homepageIntent = new Intent(getActivity(), HomePageActivity.class);
                            startActivity(homepageIntent);

                            //show confirmation message
                            Toast.makeText(view.getContext(), "Congrats on gaining a new account."
                                    , Toast.LENGTH_SHORT)
                                    .show();
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

