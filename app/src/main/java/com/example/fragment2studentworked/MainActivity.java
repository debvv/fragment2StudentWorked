package com.example.fragment2studentworked;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate (Bundle
                                     savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv;
        Button calc1B;
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView1);
        calc1B = (Button)findViewById(R.id.calc1);
        calc1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load Second Fragment
                loadFragment(new Calcul());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean
    onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true; }
        return
                super.onOptionsItemSelected(item);
    }



    private void loadFragment(Fragment   fragment) {
        // create a FragmentManager
        FragmentManager fm =     getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction =   fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the  changes
    }

}
