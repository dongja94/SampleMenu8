package com.example.dongja94.samplemenu;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerForContextMenu(findViewById(R.id.text_message));
        registerForContextMenu(findViewById(R.id.image_icon));
    }

    EditText keywordView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.menu_item1);
//        View view = MenuItemCompat.getActionView(item);
//        keywordView = (EditText)view.findViewById(R.id.edit_keyword);
//        Button btn = (Button)view.findViewById(R.id.btn_search);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String keyword = keywordView.getText().toString();
//                Toast.makeText(MainActivity.this, "Keyword : " + keyword, Toast.LENGTH_SHORT).show();
//            }
//        });
        SearchView view = (SearchView) MenuItemCompat.getActionView(item);
        view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "Query : " + query , Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item1 :
                Toast.makeText(this, "Menu 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item2 :
                Toast.makeText(this, "Menu 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item3 :
                Toast.makeText(this, "Menu 3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sub_item1 :
            case R.id.sub_item2 :
            case R.id.sub_item3 :
                Toast.makeText(this, "Sub Menu : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()) {
            case R.id.text_message :
                getMenuInflater().inflate(R.menu.menu_text, menu);
                break;
            case R.id.image_icon :
                getMenuInflater().inflate(R.menu.menu_image, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_text_item1 :
            case R.id.menu_text_item2 :
            case R.id.menu_image_item1 :
            case R.id.menu_image_item2 :
                Toast.makeText(this, "Menu : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
