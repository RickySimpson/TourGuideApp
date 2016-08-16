package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.event_list, container, false);

        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event("Hilton", R.drawable.ic_hilton));
        events.add(new Event("The Langham", R.drawable.ic_langham));
        events.add(new Event("SKYCITY Grand", R.drawable.ic_skycity));

        EventAdapter adapter = new EventAdapter(getActivity(), events);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the {@link event} object at the given position the user clicked on.
                Event event = events.get(position);

                if (position == 0) {
                    // Create an intent to take us to the HiltonActivity
                    Intent hiltonIntent = new Intent(getActivity(), HiltonActivity.class);
                    startActivity(hiltonIntent);
                } else if (position == 1) {
                    // Create an intent to take us to the LanghamActivity
                    Intent langhamIntent = new Intent(getActivity(), LanghamActivity.class);
                    startActivity(langhamIntent);
                } else if (position == 2) {
                    // Create an intent to take us to the SkycityActivity
                    Intent skycityIntent = new Intent(getActivity(), SkycityActivity.class);
                    startActivity(skycityIntent);
                }
            }
        });

        return rootView;
    }

}
