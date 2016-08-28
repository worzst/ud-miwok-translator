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

    public Word(String defaultText, String translatedText) {
        this.mDefaultText = defaultText;
        this.mTranslatedText = translatedText;
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
     * @param defaultText is the default text to be set
     */
    public void setDefaultText(String defaultText) {
        this.mDefaultText = defaultText;
    }

    /**
     * @param translatedText is the translated text to be set
     */
    public void setTranslatedText(String translatedText) {
        this.mTranslatedText = translatedText;
    }
}
