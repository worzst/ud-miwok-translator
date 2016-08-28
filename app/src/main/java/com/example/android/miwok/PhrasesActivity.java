package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    /** Handles the playback of all audio files */
    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    /** Listens for changes in audio focus */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Pause audio and seek to beginning of the audio as the words are important to hear completely
                        if (mMediaPlayer != null) {
                            mMediaPlayer.pause();
                            mMediaPlayer.seekTo(0);
                        }
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Resume playback
                        if (mMediaPlayer != null) {
                            mMediaPlayer.start();
                        }
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Stop playback and free memory
                        releaseMediaPlayer();
                    }
                }
            };

    /**
     * This listener gets triggered when the {@link MediaPlayer} has finished playing the audio file
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create and setup the {@link AudioManager} to handle audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

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
                if(word.hasAudio()) {
                    // Release the media player if the user starts a new audio file to play
                    releaseMediaPlayer();
                    // Request audio focus with the music stream and temporary
                    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    // Check if we have focus granted
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        // We have audio focus
                        // Create and start the {@link MediaPlayer} for the associated audio file
                        mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                        mMediaPlayer.start();
                        // Setup a listener to stop and release the media player when the sound has finished playing
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Stop the playing media file when the user leaves the app and free memory
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Abandon audio focus when playback is completed
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
