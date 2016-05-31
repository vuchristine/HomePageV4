package vuchris.tacoma.uw.edu.homepagev4;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Class displaying the home page.
 */
public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    /**
     * Displays buttons for the user to click on.
     * @param v the view for user to see the class's layout
     */
    public void launch(View v) {

        //create dialog fragment
        DialogFragment fragment = null;

        //if the user click on instructions button
        if (v.getId() == R.id.instructions) {
            fragment = new InstructionsFragment();
        }
        //if the user click on game button
        else if (v.getId() == R.id.game) {
            Intent gameIntent = new Intent(this, GameActivity.class);
            startActivity(gameIntent);
        }
        //if user click on invite button
        else if (v.getId() == R.id.invite) {
            Intent inviteIntent = new Intent(this, InviteActivity.class);
            startActivity(inviteIntent);
        }

        //show fragment when it's not empty
        if (fragment != null) {
            fragment.show(getSupportFragmentManager(), "launch");
        }
    }
}
