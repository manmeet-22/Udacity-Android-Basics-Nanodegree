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

public class MallsFragment extends Fragment {

    public MallsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);
        // Create a list of places0000000000000000
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.mall_elante, R.string.mall_elante_1, R.string.mall_elante_2, R.drawable.mall_elante_mall, 30.7063869, 76.7947165));
        places.add(new Place(R.string.mall_picad, R.string.mall_picad_1, R.string.mall_picad_2, R.drawable.mall_pieca_mall, 30.7235273, 76.7652874));
        places.add(new Place(R.string.mall_north, R.string.mall_north_1, R.string.mall_north_2, R.drawable.mall_north_country_mall, 30.73771, 76.6763393));
        places.add(new Place(R.string.mall_adarsh, R.string.mall_adarsh_1, R.string.mall_adarsh_2, R.drawable.mall_adardh_mall, 30.7004869, 76.7859671));

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

