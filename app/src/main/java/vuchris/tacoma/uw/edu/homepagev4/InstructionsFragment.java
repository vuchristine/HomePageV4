package vuchris.tacoma.uw.edu.homepagev4;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class InstructionsFragment extends DialogFragment {

    /**
     *
     */
    public InstructionsFragment() {
        // Required empty public constructor
    }

    /**
     * Creates a dialog for user to view instructions.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instructions, container, false);
    }

}
