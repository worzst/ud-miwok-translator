package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by worzst on 28/08/16.
 * {@link WordAdapter} is an {@link ArrayAdapter} that provides the layout for each item in a list of {@link Word} objects
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    /**
     * Custom constructor of the {@link WordAdapter}
     * @param context   Is the current context, used to inflate the layout.
     * @param words     A list of {@link Word} objects to display in a list
     */
    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    /**
     * Provides a view for an AdapterView
     * @param position      The position in the list
     * @param convertView   The recycled view to populate
     * @param parent        The parent ViewGroup, used for inflation
     * @return              The View for the position in the AdapterView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the Word object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView for the translated text and set the text
        TextView translatedTextView = (TextView) listItemView.findViewById(R.id.translated_text_view);
        translatedTextView.setText(currentWord.getTranslatedText());

        // Find the TextView for the default text and set the text
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultText());

        // Find the ImageView and set the resource specified for the word
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // If the word has an image, then set it, else hide the ImageView
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }

        // return the list item (containing 2 TextViews)
        return listItemView;
    }
}
