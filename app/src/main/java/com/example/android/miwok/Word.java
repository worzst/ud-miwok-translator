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
    private int mImageResourceId = NO_RESOURCE_PROVIDED;

    /** Resource id for the corresponding audio file for the word. */
    private int mAudioResourceId = NO_RESOURCE_PROVIDED;

    private static final int NO_RESOURCE_PROVIDED = -1;

    /**
     * Create a new Word object with only text
     * @param defaultText       is the word in the default language
     * @param translatedText    is the word in the translated language
     */
    public Word(String defaultText, String translatedText) {
        this.mDefaultText = defaultText;
        this.mTranslatedText = translatedText;
    }
    /**
     * Create a new Word object with text and image
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
     * Create a new Word object with text and audio
     * @param defaultText       is the word in the default language
     * @param translatedText    is the word in the translated language
     * @param audioResourceId   is the audio resource id corresponding to the word
     */
    public Word(int audioResourceId, String defaultText, String translatedText) {
        this.mDefaultText = defaultText;
        this.mTranslatedText = translatedText;
        this.mAudioResourceId = audioResourceId;
    }

    /**
     * Create a new Word object with text, image and audio
     * @param defaultText       is the word in the default language
     * @param translatedText    is the word in the translated language
     * @param imageResourceId   is the drawable image resource id corresponding to the word
     * @param audioResourceId   is the audio resource id corresponding to the word
     */
    public Word(String defaultText, String translatedText, int imageResourceId, int audioResourceId) {
        this.mDefaultText = defaultText;
        this.mTranslatedText = translatedText;
        this.mImageResourceId = imageResourceId;
        this.mAudioResourceId = audioResourceId;
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
     * @return an integer of the audio resource id
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    /**
     * @return true if the object has an image resource, else returns false
     */
    public boolean hasImage() {
        return mImageResourceId != NO_RESOURCE_PROVIDED;
    }

    /**
     *
     * @return true if the object has an audio resource, else returns false
     */
    public boolean hasAudio() {
        return mAudioResourceId != NO_RESOURCE_PROVIDED;
    }
}
