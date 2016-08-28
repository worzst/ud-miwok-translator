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
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object
     * @param defaultText       is the word in the default language
     * @param translatedText    is the word in the translated language
     */
    public Word(String defaultText, String translatedText) {
        this.mDefaultText = defaultText;
        this.mTranslatedText = translatedText;
    }
    /**
     * Create a new Word object
     * @param defaultText       is the word in the default language
     * @param translatedText    is the word in the translated language
     * @param imageResourceId   is the drawable image resource id corresponding to the word
     */
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
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * @return true if the object has an image, else returns false
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
