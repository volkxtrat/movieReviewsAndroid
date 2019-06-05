package com.android.moviereviews;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.moviereviews.model.MovieReview;
import com.squareup.picasso.Picasso;

public class ReviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView mReviewImage;
    private TextView mTitleTextView;
    private TextView mDescriptionTextView;

    private MovieReview mMovieReview;

    public ReviewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);

        mReviewImage = itemView.findViewById(R.id.review_item_image);
        mTitleTextView = itemView.findViewById(R.id.review_item_title);
        mDescriptionTextView = itemView.findViewById(R.id.review_item_description);
    }

    public void bind(MovieReview movieReview) {
        mMovieReview = movieReview;

        mTitleTextView.setText(movieReview.getTitle());
        mDescriptionTextView.setText(movieReview.getByline());
        if (movieReview.getMultimedia() != null)
            Picasso.get().load(movieReview.getMultimedia().getSrc())
                    .fit().centerCrop().into(mReviewImage);
        else
            mReviewImage.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        Context context = v.getContext();
        Intent i = ReviewDetailsActivity.newIntent(context, mMovieReview);
        context.startActivity(i);
    }
}
