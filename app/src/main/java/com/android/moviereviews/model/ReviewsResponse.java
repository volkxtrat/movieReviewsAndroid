package com.android.moviereviews.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ReviewsResponse implements Serializable {

    @SerializedName("status")
    private String mStatus;
    @SerializedName("has_more")
    private boolean mHasMore;
    @SerializedName("num_results")
    private int mTotalResults;
    @SerializedName("results")
    private List<MovieReview> mMovieReviews;

    public ReviewsResponse() {
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public int getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(int totalResults) {
        mTotalResults = totalResults;
    }

    public List<MovieReview> getMovieReviews() {
        return mMovieReviews;
    }

    public void setMovieReviews(List<MovieReview> movieReviews) {
        mMovieReviews = movieReviews;
    }

    public boolean isHasMore() {
        return mHasMore;
    }

    public void setHasMore(boolean hasMore) {
        mHasMore = hasMore;
    }
}
