package com.android.moviereviews.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;

public class Link extends RealmObject implements Serializable {

    @SerializedName("type")
    private String mType;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("suggested_link_text")
    private String mLinkText;

    public Link() {
    }


    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getLinkText() {
        return mLinkText;
    }

    public void setLinkText(String linkText) {
        mLinkText = linkText;
    }
}
