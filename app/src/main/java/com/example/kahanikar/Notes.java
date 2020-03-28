package com.example.kahanikar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.view.Menu;


/**
 * A simple {@link Fragment} subclass.
 */
public class Notes extends Fragment {

    public Notes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes, container, false);

    }
}
class inflaterclass extends AppCompatActivity {
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tab_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.drawer_layout);
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
        return onCreateOptionsMenu(menu);

    }
}

