package productions.darthplagueis.unit05midassessment.recyclerview.controller;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import productions.darthplagueis.unit05midassessment.R;
import productions.darthplagueis.unit05midassessment.model.Results;
import productions.darthplagueis.unit05midassessment.recyclerview.view.RandomUserViewHolder;

/**
 * Created by oleg on 1/24/18.
 */

public class RandomUserAdapter extends RecyclerView.Adapter<RandomUserViewHolder> {

    private List<Results> resultsList = new ArrayList<>();

    public RandomUserAdapter() {
        resultsList = new ArrayList<>();
    }

//    public RandomUserAdapter(List<Results> resultsList) {
//        this.resultsList = resultsList;
//    }

    @Override
    public RandomUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new RandomUserViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(RandomUserViewHolder holder, int position) {
        holder.onBind(resultsList.get(position));
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    public void clearList() {
        resultsList.clear();
    }

    public void makeAdapterList(List<Results> newList) {
        resultsList.addAll(newList);
        notifyItemRangeInserted(getItemCount(), resultsList.size() - 1);
    }

    public void updateList(List<Results> newList) {
        resultsList.addAll(newList);
        notifyDataSetChanged();
    }
}
