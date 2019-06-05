package com.android.moviereviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.moviereviews.model.MovieReview;

import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewHolder> {

    private Context mContext;
    private List<MovieReview> mMovieReviews;

    public ReviewsAdapter(Context context, List<MovieReview> movieReviews) {
        mContext = context;
        mMovieReviews = movieReviews;
    }

    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.review_item, viewGroup, false);
        return new ReviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewHolder reviewHolder, int i) {
        reviewHolder.bind(mMovieReviews.get(i));
    }

    @Override
    public int getItemCount() {
        return mMovieReviews.size();
    }

    public void setMovieReviews(List<MovieReview> movieReviews) {
        mMovieReviews = movieReviews;
    }

    public void addAll(List<MovieReview> movieReviews) {
        mMovieReviews.addAll(movieReviews);
    }
}
