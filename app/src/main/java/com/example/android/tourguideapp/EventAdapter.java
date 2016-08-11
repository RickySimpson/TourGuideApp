package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/*
* {@link EventAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link Event} objects.
* */

public class EventAdapter extends ArrayAdapter<Event> {

//    private MediaPlayer mediaPlayer;
//    private Button playButton;
//    private Button pauseButton;

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param events   A List of Word objects to display in a list
     */
    public EventAdapter(Activity context, ArrayList<Event> events, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, events);
        mColorResourceId = colorResourceId;

    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        // Get the {@link Event} object located at this position in the list
        Event currentEvent = getItem(position);

        // Find the TextView in the list_item.xml layout with the Event Title
        TextView eventTitle = (TextView) listItemView.findViewById(R.id.event_title);

        // Get the Event title from the current Event object and
        // set this text on the event title TextView
        eventTitle.setText(currentEvent.getEventTitle());

//        // Find the TextView in the list_item.xml layout with the default translation
//        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

//        // Get the default translation from the current Word object and
//        // set this text on the default language TextView
//        defaultTextView.setText(currentEvent.getEventTitle());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_item_image);

        if (currentEvent.hasImage()) {
            // Set the ImageView to the image resource specified in the current Word.
            imageView.setImageResource(currentEvent.getImageResourceId());

            // Make sure the view is visible.
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView.
            imageView.setVisibility(View.GONE);
        }


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);

        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        // Set the background color of the text container view
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout so that it can be shown in the ListView.
        return listItemView;
    }


}
