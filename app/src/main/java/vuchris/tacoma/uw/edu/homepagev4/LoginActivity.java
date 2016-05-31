package vuchris.tacoma.uw.edu.homepagev4;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Class displaying the login page.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * Launch the dialog fragments when user clicks on one of the buttons.
     * @param v view for the user to see
     */
    public void launch(View v) {

        //create dialog fragment
        DialogFragment fragment = null;

        //if the user click on sign in button
        if (v.getId() == R.id.signin_button) {
            fragment = new SignInFragment();
        }
        //if the user click on the register button
        else if (v.getId() == R.id.register_button) {
            fragment = new RegisterFragment();
        }

        //show the fragment when it's not empty
        if (fragment != null) {
            fragment.show(getSupportFragmentManager(), "launch");
        }
    }
}
