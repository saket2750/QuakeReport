package com.android.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.android.quakereport.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<QuakeReport> {

    public CustomArrayAdapter(Context context, int resource, List<QuakeReport> quakeReport) {
        super(context, resource, quakeReport);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent,false
            );
        }
        QuakeReport report = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_textView);
        magnitudeTextView.setText(String.valueOf(report.getMagnitude()));

        TextView stateTextView = (TextView) listItemView.findViewById(R.id.state_textView);
        stateTextView.setText(report.getState());

        Date dateTime = new Date(report.getDateTime());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, YYYY");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(dateFormatter.format(dateTime));

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        timeTextView.setText(timeFormatter.format(dateTime));

        return listItemView;
    }
}
