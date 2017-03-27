package com.androidexample.atommusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView shuffle = (TextView) findViewById(R.id.shuffle);

        // Set a click listener on that View
        shuffle.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the shuffle all category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ShuffleAllActivity}
                Intent shuffleIntent = new Intent(MainActivity.this, ShuffleAllActivity.class);

                // Start the new activity
                startActivity(shuffleIntent);
            }
        });

        TextView recent = (TextView) findViewById(R.id.recent);

        // Set a click listener on that View
        recent.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the recent category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link RecentActivity}
                Intent recentIntent = new Intent(MainActivity.this, RecentActivity.class);

                // Start the new activity
                startActivity(recentIntent);
            }
        });

        TextView songs = (TextView) findViewById(R.id.songs);

        // Set a click listener on that View
        songs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the songs category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SongsActivity}
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);

                // Start the new activity
                startActivity(songsIntent);
            }
        });

        TextView albums = (TextView) findViewById(R.id.albums);

        // Set a click listener on that View
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the albums category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link AlbumsActivity}
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);

                // Start the new activity
                startActivity(albumsIntent);
            }
        });

        TextView playlists = (TextView) findViewById(R.id.playlists);

        // Set a click listener on that View
        playlists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the playlists category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PlaylistsActivity}
                Intent playlistsIntent = new Intent(MainActivity.this, PlaylistsActivity.class);

                // Start the new activity
                startActivity(playlistsIntent);
            }
        });

        TextView artists  = (TextView) findViewById(R.id.artists);

        // Set a click listener on that View
        artists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the artists category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ArtistsActivity}
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);

                // Start the new activity
                startActivity(artistsIntent);
            }
        });

        TextView genres = (TextView) findViewById(R.id.genres);

        // Set a click listener on that View
        genres.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the genres category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link GenresActivity}
                Intent genresIntent = new Intent(MainActivity.this, GenresActivity.class);

                // Start the new activity
                startActivity(genresIntent);
            }
        });

        TextView nowPlaying = (TextView) findViewById(R.id.nowPlaying);

        // Set a click listener on that View
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Now Playing category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NowPlayingActivity}
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);

                // Start the new activity
                startActivity(nowPlayingIntent);
            }
        });

        ImageView nowPlayingDock = (ImageView) findViewById(R.id.dock);

        // Set a click listener on that View
        nowPlayingDock.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Now Playing category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NowPlayingActivity}
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);

                // Start the new activity
                startActivity(nowPlayingIntent);
            }
        });

        TextView setting = (TextView) findViewById(R.id.settings);

        // Set a click listener on that View
        setting.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the setting category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SettingsActivity}
                Intent settingIntent = new Intent(MainActivity.this, SettingsActivity.class);

                // Start the new activity
                startActivity(settingIntent);
            }
        });

    }
}
