package productions.darthplagueis.unit05midassessment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import productions.darthplagueis.unit05midassessment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgressBarFragment extends Fragment {


    public ProgressBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_progress_bar, container, false);
    }

}
