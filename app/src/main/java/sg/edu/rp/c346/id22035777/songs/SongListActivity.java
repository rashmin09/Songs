package sg.edu.rp.c346.id22035777.songs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

// SongListActivity.java

public class SongListActivity extends AppCompatActivity {

    ListView lv;
    DBHelper db;
    Button btnShow5StarSongs;
    Spinner spinnerYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        lv = findViewById(R.id.lv);
        db = new DBHelper(SongListActivity.this);
        btnShow5StarSongs = findViewById(R.id.btnShow5StarSongs);
        spinnerYear = findViewById(R.id.spinnerYear);

        // Retrieve all songs initially
        ArrayList<Song> songList = db.getSongs();

        ArrayAdapter<Song> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) parent.getItemAtPosition(position);

                Intent intent = new Intent(SongListActivity.this, SongDetailsEditActivity.class);
                intent.putExtra("songId", song.getId());
                startActivity(intent);
            }
        });

        btnShow5StarSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Song> fiveStarSongs = db.getFiveStarSongs();
                adapter.clear();
                adapter.addAll(fiveStarSongs);
                adapter.notifyDataSetChanged();
            }
        });


        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, db.getDistinctYears());
        spinnerYear.setAdapter(yearAdapter);
        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedYear = parent.getItemAtPosition(position).toString();
                ArrayList<Song> filteredSongs = db.getSongsByYear(selectedYear);
                adapter.clear();
                adapter.addAll(filteredSongs);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}


