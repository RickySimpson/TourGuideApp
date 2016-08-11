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
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.event_list, container, false);


        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
       // events.add(new Event("Sky Tower", R.drawable.ic_skytower));
//        events.add(new Event("Harbour Bridge Climb", R.drawable.ic_harbourbridge));
        events.add(new Event("Auckland City Viaduct", R.drawable.ic_auckland));

        EventAdapter adapter = new EventAdapter(getActivity(), events, R.color.category_islands);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the {@link event} object at the given position the user clicked on.
                Event event = events.get(position);

                if (position == 0) {
                    Intent skyTowerIntent = new Intent(getActivity(), SkyTowerActivity.class);
                    startActivity(skyTowerIntent);
                } else if (position == 1) {
                    Intent bridgeIntent = new Intent(getActivity(), BridgeActivity.class);
                    startActivity(bridgeIntent);
                } else if (position == 2) {
                    Intent viaductIntent = new Intent(getActivity(), ViaductActivity.class);
                    startActivity(viaductIntent);
                }

            }
        });

        return rootView;
    }

}
