package com.android.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.android.quakereport.R;

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

        TextView dateTimeTextView = (TextView) listItemView.findViewById(R.id.dateTime_textView);
        dateTimeTextView.setText(report.getDateTime());

        return listItemView;
    }
}
