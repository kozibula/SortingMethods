package com.nasko.naz.sortingmethods;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    Button bubbleSortButton;
    Button insertionSortButton;
    Button selectionSortButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setTitle("   " + "Методи за сортиране");

        bubbleSortButton = (Button) findViewById(R.id.button_bubble);
        insertionSortButton = (Button) findViewById(R.id.button_insertion);
        selectionSortButton = (Button) findViewById(R.id.button_selection);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Toast.makeText(getApplicationContext(), "Made by Nasko Georgiev", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onBubbleSortClick(View view) {

        Intent getSortingScreenIntent = new Intent(this,
                SortingActivity.class);

        final int result = 1;

        getSortingScreenIntent.putExtra("sortingMethod", "Bubble");
        startActivity(getSortingScreenIntent);
    }

    public void onInsertionSortClick(View view) {

        Intent getSortingScreenIntent = new Intent(this,
                SortingActivity.class);

        final int result = 1;

        getSortingScreenIntent.putExtra("sortingMethod", "Insertion");
        startActivity(getSortingScreenIntent);
    }

    public void onSelectionSortClick(View view) {

        Intent getSortingScreenIntent = new Intent(this,
                SortingActivity.class);

        final int result = 1;

        getSortingScreenIntent.putExtra("sortingMethod", "Selection");
        startActivity(getSortingScreenIntent);
    }

}
