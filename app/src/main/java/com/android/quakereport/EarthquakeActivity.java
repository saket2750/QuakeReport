package com.android.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        ArrayList<QuakeReport> earthquakes = new ArrayList<>();
        earthquakes.add(new QuakeReport(6.2f,"San Francisco","31-Jan 2021"));
        earthquakes.add(new QuakeReport(7.2f,"London","30-Jan 2021"));
        earthquakes.add(new QuakeReport(6.2f,"Tokyo","31-Jan 2021"));
        earthquakes.add(new QuakeReport(6.2f,"Mexico City","31-Jan 2021"));
        earthquakes.add(new QuakeReport(6.2f,"Moscow","31-Jan 2021"));
        earthquakes.add(new QuakeReport(6.2f,"Rio de Janerio","31-Jan 2021"));
        earthquakes.add(new QuakeReport(6.2f,"Paris","31-Jan 2021"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        CustomArrayAdapter adapter = new CustomArrayAdapter(
                EarthquakeActivity.this, android.R.layout.simple_list_item_1, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}