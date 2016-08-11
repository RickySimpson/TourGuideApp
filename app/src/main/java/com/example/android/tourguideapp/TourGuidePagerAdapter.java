package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * {@link TourGuidePagerAdapter} is a {@link FragmentPagerAdapter} that can provide the layout
 * for each list item based on a data source which is a list of {@link Event} objects.
 */
public class TourGuidePagerAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link TourGuidePagerAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public TourGuidePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new BeachesFragment();
        } else if (position == 1) {
            return new IslandsFragment();
        } else {
            return new AttractionsFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_beaches);
        } else if (position == 1) {
            return mContext.getString(R.string.category_islands);
        } else {
            return mContext.getString(R.string.category_attractions);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
