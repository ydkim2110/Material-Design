package com.example.anti2110.materialdesign.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.anti2110.materialdesign.R;

public class ToolbarActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.item1_id:
                Toast.makeText(this, "item 1 selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2_id:
                Toast.makeText(this, "item 2 selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3_id:
                Toast.makeText(this, "item 3 selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_id:
                Toast.makeText(this, "search selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cart_id:
                Toast.makeText(this, "cart selected", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Toast.makeText(this, "home selected", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
