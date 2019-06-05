package com.android.moviereviews;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.moviereviews.model.MovieReview;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ReviewDetailsFragment extends Fragment {

    private static final String TAG = "ReviewDetailsFragment";
    private static final String ARG_REVIEW = "MovieReview";

    private ImageView mReviewImage;
    private TextView mTitleTextView;
    private TextView mSummaryTextView;
    private TextView mOpeningTextView;
    private TextView mBylineTextView;
    private Button mLinkButton;

    private MovieReview mMovieReview;

    public static ReviewDetailsFragment newInstance(MovieReview review) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_REVIEW, review);

        ReviewDetailsFragment fragment = new ReviewDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if (getArguments() != null)
            mMovieReview = (MovieReview) getArguments().getSerializable(ARG_REVIEW);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_details, container, false);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.getSupportActionBar().setTitle(R.string.review_title);
            activity.getSupportActionBar()
                    .setSubtitle(formatDate(mMovieReview.getPublicationDate()));
        }

        mReviewImage = view.findViewById(R.id.review_image);
        Log.i(TAG, mMovieReview.getMultimedia().getSrc());
        Picasso.get().load(mMovieReview.getMultimedia().getSrc()).into(mReviewImage);

        mTitleTextView = view.findViewById(R.id.review_title);
        mTitleTextView.setText(mMovieReview.getHeadline());

        mSummaryTextView = view.findViewById(R.id.review_summary_short);
        mSummaryTextView.setText(mMovieReview.getSummaryShort());

        mOpeningTextView = view.findViewById(R.id.review_opening_date);
        mOpeningTextView.setText(formatDate(mMovieReview.getOpeningDate()));

        mBylineTextView = view.findViewById(R.id.review_byline);
        mBylineTextView.setText(mMovieReview.getByline());

        mLinkButton = view.findViewById(R.id.review_link_button);
        mLinkButton.setText(mMovieReview.getLink().getLinkText());
        mLinkButton.setOnClickListener(v ->
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(mMovieReview.getLink().getUrl()))));
        return view;
    }

    private String formatDate(String date) {
        if (date.equals("Not Defined"))
            return date;

        DateFormat format = new SimpleDateFormat(
                getResources().getString(R.string.api_date_format), Locale.getDefault());
        Date apiDate = null;
        try {
            apiDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        format = new SimpleDateFormat(
                getResources().getString(R.string.date_format), Locale.getDefault());

        return format.format(apiDate);
    }
}
