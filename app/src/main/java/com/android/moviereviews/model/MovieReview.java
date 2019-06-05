package com.android.moviereviews.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MovieReview extends RealmObject implements Serializable {

//    @PrimaryKey
    @SerializedName("display_title")
    private String mTitle;
    @SerializedName("byline")
    private String mByline;
    @SerializedName("headline")
    private String mHeadline;
    @SerializedName("summary_short")
    private String mSummaryShort;
    @SerializedName("publication_date")
    private String mPublicationDate;
    @SerializedName("opening_date")
    private String mOpeningDate;
    @SerializedName("link")
    private Link mLink;
    @SerializedName("multimedia")
    private Multimedia mMultimedia;

    public MovieReview() {
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getByline() {
        return mByline;
    }

    public void setByline(String byline) {
        mByline = byline;
    }

    public String getHeadline() {
        return mHeadline;
    }

    public void setHeadline(String headline) {
        mHeadline = headline;
    }

    public String getSummaryShort() {
        return mSummaryShort;
    }

    public void setSummaryShort(String summaryShort) {
        mSummaryShort = summaryShort;
    }

    public String getPublicationDate() {
        return mPublicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        mPublicationDate = publicationDate;
    }

    public String getOpeningDate() {
        if (mOpeningDate == null || mOpeningDate.isEmpty())
            return "Not Defined";
        return mOpeningDate;
    }

    public void setOpeningDate(String openingDate) {
        mOpeningDate = openingDate;
    }

    public Link getLink() {
        return mLink;
    }

    public void setLink(Link link) {
        mLink = link;
    }

    public Multimedia getMultimedia() {
        return mMultimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        mMultimedia = multimedia;
    }
}
