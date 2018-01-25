package productions.darthplagueis.unit05midassessment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import productions.darthplagueis.unit05midassessment.R;
import productions.darthplagueis.unit05midassessment.model.RandomUsers;
import productions.darthplagueis.unit05midassessment.model.Results;
import productions.darthplagueis.unit05midassessment.recyclerview.controller.RandomUserAdapter;
import productions.darthplagueis.unit05midassessment.retrofit.RandomUserGetter;
import productions.darthplagueis.unit05midassessment.retrofit.RandomUserRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private RandomUserGetter randomUserGetter;
    private RecyclerView recyclerView;
    private RandomUserAdapter adapter;


    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        setHasOptionsMenu(true);

        recyclerView = rootView.findViewById(R.id.recycler_view);

        setRetrofit();
        adapter = new RandomUserAdapter();
        getRandomUsers();
        recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), 2));
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private void setRetrofit() {
        RandomUserRetrofit retrofit = RandomUserRetrofit.getInstanceOfRetrofit();
        randomUserGetter = retrofit.randomUserGetter();
    }

    private void getRandomUsers() {
        Call<RandomUsers> call = randomUserGetter.getRandomUsers();
        call.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, Response<RandomUsers> response) {
                if (response.isSuccessful()) {
                    RandomUsers randomUsers = response.body();
                    List<Results> resultsList = randomUsers.getResults();
                    adapter.makeAdapterList(resultsList);
                    Log.d("RecyclerFrag", "onResponse list size:  " + resultsList.size());
                    Log.d("RecyclerFrag", "onResponse: " + response.raw());
                }
            }

            @Override
            public void onFailure(Call<RandomUsers> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void getMoreRandomUsers() {
        Call<RandomUsers> call = randomUserGetter.getRandomUsers();
        call.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, Response<RandomUsers> response) {
                if (response.isSuccessful()) {
                    RandomUsers randomUsers = response.body();
                    List<Results> resultsList = randomUsers.getResults();
                    adapter.clearList();
                    adapter.updateList(resultsList);
                    Log.d("RecyclerFrag", "onResponse list size:  " + resultsList.size());
                    Log.d("RecyclerFrag", "onResponse: " + response.raw());
                }
            }

            @Override
            public void onFailure(Call<RandomUsers> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action01:
                getMoreRandomUsers();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
