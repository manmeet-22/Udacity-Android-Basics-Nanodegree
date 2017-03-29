package com.androidexample.chandigarhexplore;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MANI on 1/12/2017.
 */
public class PlaceAdapter extends ArrayAdapter<Place> {

    private int mColorResourceId;

    public PlaceAdapter(Context context, ArrayList<Place> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Place currentPlace = getItem(position);
        TextView locationView = (TextView) listItemView.findViewById(R.id.location);
        locationView.setText(currentPlace.getLocationId());

        TextView addressOneView = (TextView) listItemView.findViewById(R.id.address1);
        addressOneView.setText(currentPlace.getAddressOneId());

        TextView addressTwoView = (TextView) listItemView.findViewById(R.id.address2);
        addressTwoView.setText(currentPlace.getAddressTwoId());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentPlace.getPlaceImageId());

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
