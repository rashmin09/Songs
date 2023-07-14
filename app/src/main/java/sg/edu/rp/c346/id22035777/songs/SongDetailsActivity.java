package sg.edu.rp.c346.id22035777.songs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SongDetailsActivity extends AppCompatActivity {

    TextView tvTitle, tvSingers, tvYear, tvStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        tvTitle = findViewById(R.id.tvTitle);
        tvSingers = findViewById(R.id.tvSingers);
        tvYear = findViewById(R.id.tvYear);
        tvStars = findViewById(R.id.tvStars);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("song")) {
            Song song = intent.getParcelableExtra("song");

            if (song != null) {
                tvTitle.setText(song.getTitle());
                tvSingers.setText(song.getSingers());
                tvYear.setText(String.valueOf(song.getYear()));
                tvStars.setText(String.valueOf(song.getStars()));
            }
        }
    }
}
