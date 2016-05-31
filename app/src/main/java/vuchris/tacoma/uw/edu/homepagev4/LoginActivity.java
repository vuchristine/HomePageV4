package vuchris.tacoma.uw.edu.homepagev4;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //when user clicks the button, signin or register dialog pops up
    public void launch(View v) {
        DialogFragment fragment = null;
        if (v.getId() == R.id.signin_button) {
            fragment = new SignInFragment();
        } else if (v.getId() == R.id.register_button) {
            fragment = new RegisterFragment();
        }

        //show
        if (fragment != null) {
            fragment.show(getSupportFragmentManager(), "launch");
        }
    }
}
