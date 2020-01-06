package com.example.miwokapp;

public class Words {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mResourceId;
    private int mSongsId;


    public Words(String defaultTranslation, String miwokTranslation, int songsId) {
        //mDefaultTranslation = defaultTranslation;
        //mMiwokTranslation = miwokTranslation;
        this(defaultTranslation,miwokTranslation,-1,songsId);
    }

    public Words(String defaultTranslation, String miwokTranslation, int resourceId,int songsId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mResourceId = resourceId;
        mSongsId = songsId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getResourceId() {
        return mResourceId;
    }

    public int getmSongsId() {
        return mSongsId;
    }


    // overriding toString() method
    @Override
    public String toString() {
        return "Words{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mResourceId=" + mResourceId +
                ", mSongsId=" + mSongsId +
                '}';
    }
}
