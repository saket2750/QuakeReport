package com.android.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.GradientDrawable;

import com.android.quakereport.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<QuakeReport> {

    private static final String LOCATION_SEPARATOR = " of ";

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

        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude_textView);
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magnitudeValue = formatter.format(report.getMagnitude());
        magnitudeTextView.setText(magnitudeValue);


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(report.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String state = report.getState();
        String offset, location;
        if (state.contains(LOCATION_SEPARATOR)) {
            String[] parts = state.split(LOCATION_SEPARATOR);
            offset = parts[0] + LOCATION_SEPARATOR;
            location = parts[1];
        } else {
            offset = getContext().getString(R.string.near_the);
            location = state;
        }

        TextView locationOffset = listItemView.findViewById(R.id.locationOffset);
        locationOffset.setText(offset);

        TextView primaryLocation = listItemView.findViewById(R.id.primaryLocation);
        primaryLocation.setText(location);

        Date dateTime = new Date(report.getDateTime());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");

        TextView dateTextView = listItemView.findViewById(R.id.date);
        dateTextView.setText(dateFormatter.format(dateTime));

        TextView timeTextView = listItemView.findViewById(R.id.time);
        timeTextView.setText(timeFormatter.format(dateTime));

        return listItemView;
    }

    private int getMagnitudeColor(double d){
        int magColorResId;
        int magFloor = (int) Math.floor(d);
        switch(magFloor) {
            case 0:
            case 1:
                magColorResId = R.color.magnitude1;
                break;
            case 2:
                magColorResId = R.color.magnitude2;
                break;
            case 3:
                magColorResId = R.color.magnitude3;
                break;
            case 4:
                magColorResId = R.color.magnitude4;
                break;
            case 5:
                magColorResId = R.color.magnitude5;
                break;
            case 6:
                magColorResId = R.color.magnitude6;
                break;
            case 7:
                magColorResId = R.color.magnitude7;
                break;
            case 8:
                magColorResId = R.color.magnitude8;
                break;
            case 9:
                magColorResId = R.color.magnitude9;
                break;
            default:
                magColorResId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magColorResId);
    }
}
