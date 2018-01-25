package productions.darthplagueis.unit05midassessment.recyclerview.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import productions.darthplagueis.unit05midassessment.MainActivity;
import productions.darthplagueis.unit05midassessment.R;
import productions.darthplagueis.unit05midassessment.fragments.DetailsFragment;
import productions.darthplagueis.unit05midassessment.model.Results;

/**
 * Created by oleg on 1/24/18.
 */

public class RandomUserViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    private ImageView imageView;
    private TextView textView;

    public RandomUserViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        imageView = itemView.findViewById(R.id.image_item_view);
        textView = itemView.findViewById(R.id.text_item_view);
    }

    public void onBind(final Results results) {
        Glide.with(context)
                .load(results.getPicture().getMedium())
                .into(imageView);

        final String firstLastName = results.getName().getFirst() + " " + results.getName().getLast();
        textView.setText(firstLastName);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] strings = new String[]{results.getPicture().getLarge(), firstLastName, results.getDob(), results.getLocation().getStreet(), results.getLocation().getCity(),
                results.getLocation().getState(), String.valueOf(results.getLocation().getPostcode()), results.getCell(), results.getEmail()};
                Bundle bundle = new Bundle();
                bundle.putStringArray("strings", strings);
                DetailsFragment fragment = new DetailsFragment();
                FragmentTransaction transaction = ((MainActivity) context).getSupportFragmentManager().beginTransaction();
                fragment.setArguments(bundle);
                transaction.replace(R.id.main_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
