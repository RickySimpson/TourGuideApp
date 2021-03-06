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
public class BeachesFragment extends Fragment {

    public BeachesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.event_list, container, false);

        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event("Piha", R.drawable.ic_piha));
        events.add(new Event("Tawharanui", R.drawable.ic_tawharanuibeach));
        events.add(new Event("Orewa", R.drawable.ic_orewabeach));

        EventAdapter adapter = new EventAdapter(getActivity(), events);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the {@link event} object at the given position the user clicked on.
                Event event = events.get(position);

                if (position == 0) {
                    // Create an intent to take us to the PihaActivity
                    Intent pihaIntent = new Intent(getActivity(), PihaActivity.class);
                    startActivity(pihaIntent);
                } else if (position == 1) {
                    // Create an intent to take us to the TawharanuiActivity
                    Intent tawharanguiItent = new Intent(getActivity(), TawharanuiActivity.class);
                    startActivity(tawharanguiItent);
                } else if (position == 2) {
                    // Create an intent to take us to the OrewaActivity
                    Intent orewaIntent = new Intent(getActivity(), OrewaActivity.class);
                    startActivity(orewaIntent);
                }
            }
        });

        return rootView;
    }

}
