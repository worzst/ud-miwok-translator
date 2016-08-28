package com.example.android.miwok;

/**
 * Created by worzst on 28/08/16.
 * {@link Word} represents a word and its translation in 1 other language
 */
public class Word {

    /** Default text of the word */
    private String mDefaultText;

    /** Translated text of the word */
    private String mTranslatedText;

    /** Resource id for the corresponding image for the word */
    private int mImageResourceId;

    public Word(String defaultText, String translatedText) {
        this.mDefaultText = defaultText;
        this.mTranslatedText = translatedText;
    }

    public Word(String defaultText, String translatedText, int imageResourceId) {
        this.mDefaultText = defaultText;
        this.mTranslatedText = translatedText;
        this.mImageResourceId = imageResourceId;
    }

    /**
     * @return the default text
     */
    public String getDefaultText() {
        return mDefaultText;
    }

    /**
     * @return the translated text
     */
    public String getTranslatedText() {
        return mTranslatedText;
    }

    /**
     * @return an integer of the image resource id
     */
    public int getmImageResourceId() {
        return mImageResourceId;
    }
}
