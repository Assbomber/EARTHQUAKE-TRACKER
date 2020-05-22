package com.example.earthquakefromstart;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import java.net.MalformedURLException;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C1019R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(C1019R.C1022id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle((CharSequence) "Earthquake App");
        toolbar.setTitleTextColor(getResources().getColor(C1019R.C1020color.white));
        getSupportFragmentManager().beginTransaction().replace(C1019R.C1022id.framelayout, new FragmentA()).commit();
        Asynctask asynctask = null;
        try {
            asynctask = new Asynctask(this, getSupportFragmentManager());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        asynctask.execute(new Void[0]);
        BottomNavigationView bottomNavigationView2 = (BottomNavigationView) findViewById(C1019R.C1022id.bottomnavigation);
        this.bottomNavigationView = bottomNavigationView2;
        bottomNavigationView2.setSelectedItemId(C1019R.C1022id.menu_home);
        this.bottomNavigationView.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case C1019R.C1022id.menu_home /*2131362049*/:
                        try {
                            HomeActivity.this.getSupportFragmentManager().beginTransaction().replace(C1019R.C1022id.framelayout, new FragmentB(HomeActivity.this)).commit();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        return true;
                    case C1019R.C1022id.menu_map /*2131362050*/:
                        HomeActivity.this.getSupportFragmentManager().beginTransaction().replace(C1019R.C1022id.framelayout, new FragmentC()).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
