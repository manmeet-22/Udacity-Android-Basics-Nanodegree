package com.androidexample.chandigarhexplore;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TourismFragment();
        } else if (position == 1) {
            return new MallsFragment();
        } else if (position == 2) {
            return new CinemasFragment();
        } else {
            return new RestaurantsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_tourism);
        } else if (position == 1) {
            return mContext.getString(R.string.category_mall);
        } else if (position == 2) {
            return mContext.getString(R.string.category_cinema);
        } else {
            return mContext.getString(R.string.category_rest);
        }
    }
}