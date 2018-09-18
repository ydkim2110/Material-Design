package com.example.anti2110.materialdesign.navigationDraw;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.anti2110.materialdesign.R;

public class NavigationDrawActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_draw);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.inbox_id:
                Toast.makeText(this, "Inbox selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.starred_id:
                Toast.makeText(this, "Starred selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sent_id:
                Toast.makeText(this, "Sent selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.drafts_id:
                Toast.makeText(this, "Drafts selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.allmail_id:
                Toast.makeText(this, "All Mail selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trash_id:
                Toast.makeText(this, "Trash selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.spam_id:
                Toast.makeText(this, "Spam selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
