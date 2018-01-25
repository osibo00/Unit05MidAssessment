package productions.darthplagueis.unit05midassessment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import productions.darthplagueis.unit05midassessment.fragments.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inflateRecyclerViewFrag();
    }

    private void inflateRecyclerViewFrag() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        RecyclerViewFragment fragment = (RecyclerViewFragment) getSupportFragmentManager().findFragmentByTag("recyclerFrag");
        if (fragment == null) {
            transaction.add(R.id.main_container, new RecyclerViewFragment(), "recyclerFrag");
        } else {
            transaction.replace(R.id.main_container, fragment, "recyclerFrag");
        }
        transaction.commit();
    }
}
