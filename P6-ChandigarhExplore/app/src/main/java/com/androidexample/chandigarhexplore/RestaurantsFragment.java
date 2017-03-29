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

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);
        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.restaurant_swag,R.string.restaurant_swag_1, R.string.restaurant_swag_2,
                R.drawable.restaurant_swagath,30.72851,76.8021428));
        places.add(new Place(R.string.restaurant_virgin,R.string.restaurant_virgin_1, R.string.restaurant_virgin_2,
                R.drawable.restaurant_virgin,30.7343645,76.7953791));
        places.add(new Place(R.string.restaurant_pirates,R.string.restaurant_pirates_1, R.string.restaurant_pirates_2,
                R.drawable.restaurant_pirates,30.7059303,76.7985013));
        places.add(new Place(R.string.restaurant_china,R.string.restaurant_china_1, R.string.restaurant_china_2,
                R.drawable.restaurant_mainland,30.725223,76.8034613));
        places.add(new Place(R.string.restaurant_delux,R.string.restaurant_delux_1, R.string.restaurant_delux_2,
                R.drawable.restaurant_delux,30.7160944,76.8027994));

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


