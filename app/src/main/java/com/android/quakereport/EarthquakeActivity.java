package com.android.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.customadapter.CustomArrayAdapter;
import com.android.customadapter.QuakeReport;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<QuakeReport> earthquakes = QueryUtil.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        CustomArrayAdapter adapter = new CustomArrayAdapter(
                EarthquakeActivity.this, android.R.layout.simple_list_item_1, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener((adapterView, view, position, l) -> {
            QuakeReport report = adapter.getItem(position);
            Uri earthQuakeUri = Uri.parse(report.getUrl());
            Intent webIntent = new Intent(Intent.ACTION_VIEW, earthQuakeUri);
            startActivity(webIntent);
        });
    }
}