package com.android.moviereviews.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;

public class Multimedia extends RealmObject implements Serializable {

    @SerializedName("type")
    private String mType;
    @SerializedName("src")
    private String mSrc;
    @SerializedName("width")
    private int mWidth;
    @SerializedName("height")
    private int mHeight;

    public Multimedia() {
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getSrc() {
        return mSrc;
    }

    public void setSrc(String src) {
        mSrc = src;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        mWidth = width;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

}
