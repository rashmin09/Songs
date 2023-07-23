package sg.edu.rp.c346.id22035777.songs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etTitle, etSingers, etYear;
    RadioGroup rgStars;
    Button btnInsert, btnShow, btnEdit;
    ListView lvSongs;
    ArrayList<Song> alSongs;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        rgStars = findViewById(R.id.rgStars);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);
        btnEdit = findViewById(R.id.btnEdit);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString().trim();
                String singers = etSingers.getText().toString().trim();
                String yearString = etYear.getText().toString().trim();
                String starsString = ((RadioButton) findViewById(rgStars.getCheckedRadioButtonId())).getText().toString().trim();

                if (!title.isEmpty() && !singers.isEmpty() && !yearString.isEmpty() && !starsString.isEmpty()) {
                    int year = Integer.parseInt(yearString);
                    int stars = Integer.parseInt(starsString);

                    DBHelper db = new DBHelper(MainActivity.this);
                    db.insertSong(title, singers, year, stars);
                    etTitle.setText("");
                    etSingers.setText("");
                    etYear.setText("");
                    rgStars.clearCheck();
                }
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongDetailsEditActivity.class);
                startActivity(intent);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongListActivity.class);
                startActivity(intent);
            }
        });
    }
}
