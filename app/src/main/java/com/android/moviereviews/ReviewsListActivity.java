package com.android.moviereviews;

import android.support.v4.app.Fragment;

public class ReviewsListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return ReviewsListFragment.newInstance();
    }
}
