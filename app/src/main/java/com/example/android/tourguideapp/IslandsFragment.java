package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class IslandsFragment extends Fragment {


    public IslandsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.event_list, container, false);


        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
//        events.add(new Event("Rangitoto", R.drawable.ic_rangitotoisland1));
//        events.add(new Event("Kawau", R.drawable.ic_kawauisland));
//        events.add(new Event("Waiheke", R.drawable.ic_waihekeisland));


        EventAdapter adapter = new EventAdapter(getActivity(), events, R.color.category_islands);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the {@link word} object at the given position the user clicked on.
                Event event = events.get(position);

                if (position == 0) {
                    Intent rangitotoItent = new Intent(getActivity(), RangitotoActivity.class);
                    startActivity(rangitotoItent);
                } else if (position == 1) {
                    Intent kawauItent = new Intent(getActivity(), KawauActivity.class);
                    startActivity(kawauItent);
                } else if (position == 2) {
                    Intent waihekeIntent = new Intent(getActivity(), WaihekeActivity.class);
                    startActivity(waihekeIntent);
                }

            }
        });

        return rootView;
    }

}
