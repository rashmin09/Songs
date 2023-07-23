package sg.edu.rp.c346.id22035777.songs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Song> {

    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvSingers = rowView.findViewById(R.id.tvSingers);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        TextView tvStars = rowView.findViewById(R.id.tvStars);

        Song currentSong = songList.get(position);

        tvTitle.setText(currentSong.getTitle());
        tvSingers.setText(currentSong.getSingers());
        tvYear.setText(String.valueOf(currentSong.getYear()));
        tvStars.setText(String.valueOf(currentSong.getStars()));


        return rowView;
    }
}

