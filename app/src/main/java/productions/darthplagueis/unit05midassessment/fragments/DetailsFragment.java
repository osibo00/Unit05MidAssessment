package productions.darthplagueis.unit05midassessment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import productions.darthplagueis.unit05midassessment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    private String[] strings;


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        Bundle args = getArguments();
        if (args != null) {
            strings = args.getStringArray("strings");
        }
        ImageView imageView = rootView.findViewById(R.id.details_image);
        Glide.with(rootView.getContext())
                .load(strings[0])
                .into(imageView);

        TextView textView01 = rootView.findViewById(R.id.details_name);
        TextView textView02 = rootView.findViewById(R.id.details_dob);
        TextView textView03 = rootView.findViewById(R.id.details_street);
        TextView textView04 = rootView.findViewById(R.id.details_city);
        TextView textView05 = rootView.findViewById(R.id.details_state);
        TextView textView06 = rootView.findViewById(R.id.details_postcode);
        TextView textView07 = rootView.findViewById(R.id.details_cell);
        TextView textView08 = rootView.findViewById(R.id.details_email);

        textView01.setText(strings[1]);
        textView02.setText(strings[2]);
        textView03.setText(strings[3]);
        textView04.setText(strings[4]);
        textView05.setText(strings[5]);
        textView06.setText(strings[6]);
        textView07.setText(strings[7]);
        textView08.setText(strings[8]);

        return rootView;
    }

}
