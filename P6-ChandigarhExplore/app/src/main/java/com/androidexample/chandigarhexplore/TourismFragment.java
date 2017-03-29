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
public class TourismFragment extends Fragment {

    public TourismFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);
        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.tourism_rock,R.string.tourism_rock_1,R.string.tourism_rock_2,
                R.drawable.tourism_rock_garden,30.753491,76.805420));
        places.add(new Place(R.string.tourism_rose,R.string.tourism_rose_1, R.string.tourism_rose_2,R.drawable.tourism_rose_garden,30.746108,76.781981));
        places.add(new Place(R.string.tourism_sukhna,R.string.tourism_sukhna_1, R.string.tourism_sukhna_2,R.drawable.tourism_sukhna_lake,30.7421,76.8188));
        places.add(new Place(R.string.tourism_doll,R.string.tourism_doll_1, R.string.tourism_doll_2,R.drawable.tourism_international_doll_museum,30.7416,76.7708));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.white_font);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Sending values to the IndividualInfo Activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Place current = places.get(position);
                Intent details = new Intent(getActivity() ,IndividualInfoActivity.class);
                details.putExtra("location" , current.getLocationId());
                details.putExtra("locationAdd1",current.getAddressOneId());
                details.putExtra("locationAdd2",current.getAddressTwoId());
                details.putExtra("locationLon", current.getLongitudeId());
                details.putExtra("locationLat", current.getLatitudeId());
                details.putExtra("locationImage", current.getPlaceImageId());
                startActivity(details);
            }

        });

        return rootView;
    }
}

