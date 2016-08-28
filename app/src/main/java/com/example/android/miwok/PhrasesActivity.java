package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of word objects
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(R.raw.phrase_where_are_you_going, "Where are you going?", "minto wuksus"));
        words.add(new Word(R.raw.phrase_what_is_your_name, "What is your name?", "tinnә oyaase'nә"));
        words.add(new Word(R.raw.phrase_my_name_is, "My name is...", "oyaaset..."));
        words.add(new Word(R.raw.phrase_how_are_you_feeling, "How are you feeling?", "michәksәs?"));
        words.add(new Word(R.raw.phrase_im_feeling_good, "I’m feeling good.", "kuchi achit"));
        words.add(new Word(R.raw.phrase_are_you_coming, "Are you coming?", "әәnәs'aa?"));
        words.add(new Word(R.raw.phrase_yes_im_coming, "Yes, I’m coming.", "hәә’ әәnәm"));
        words.add(new Word(R.raw.phrase_im_coming, "I’m coming.", "әәnәm"));
        words.add(new Word(R.raw.phrase_lets_go, "Let’s go.", "yoowutis"));
        words.add(new Word(R.raw.phrase_come_here, "Come here.", "әnni'nem"));

        // Create an adapter and find the ListView on the screen and populate the data
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set OnItemClickListener which plays the corresponding audio when clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}
