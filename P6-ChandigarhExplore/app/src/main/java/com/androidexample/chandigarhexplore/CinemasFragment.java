/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.androidexample.chandigarhexplore;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CinemasFragment extends Fragment {

    public CinemasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);
        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.cinema_pvr, R.string.cinema_pvr_1, R.string.cinema_pvr_2,
                R.drawable.cinema_pvr, 30.7050649, 76.7929105));
        places.add(new Place(R.string.cinema_hyperx, R.string.cinema_hyperx_1, R.string.cinema_hyperx_2,
                R.drawable.cinema_hyperx, 30.7050652, 76.7994766));
        places.add(new Place(R.string.cinema_fun, R.string.cinema_fun_1, R.string.cinema_fun_2,
                R.drawable.cinema_fun, 30.7278498, 76.7973474));
        places.add(new Place(R.string.cinema_wave, R.string.cinema_wave_1, R.string.cinema_wave_2,
                R.drawable.cinema_wave, 30.7095765, 76.7988023));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.white_font);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Sending values to the IndividualInfo Activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Place current = places.get(position);
                Intent details = new Intent(getActivity(), IndividualInfoActivity.class);
                details.putExtra("location", current.getLocationId());
                details.putExtra("locationAdd1", current.getAddressOneId());
                details.putExtra("locationAdd2", current.getAddressTwoId());
                details.putExtra("locationLon", current.getLongitudeId());
                details.putExtra("locationLat", current.getLatitudeId());
                details.putExtra("locationImage", current.getPlaceImageId());
                startActivity(details);
            }

        });

        return rootView;
    }
}

