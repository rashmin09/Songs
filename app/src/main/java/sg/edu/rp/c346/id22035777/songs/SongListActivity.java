package sg.edu.rp.c346.id22035777.songs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        lv = findViewById(R.id.lv);

        DBHelper db = new DBHelper(SongListActivity.this);
        ArrayList<Song> songList = db.getSongs();
        db.close();

        // Create an ArrayList of strings to display in the ListView
        ArrayList<String> songInfoList = new ArrayList<>();
        for (Song song : songList) {
            String songInfo = "Title: " + song.getTitle() +
                    "\nSingers: " + song.getSingers() +
                    "\nYear: " + song.getYear() +
                    "\nStars: " + song.getStars();
            songInfoList.add(songInfo);
        }

        // Create an ArrayAdapter to display the song information in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songInfoList);
        lv.setAdapter(adapter);
    }
}

