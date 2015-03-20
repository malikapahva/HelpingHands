package com.re.HelpingHands.activity.general;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.re.HelpingHands.R;
import com.re.HelpingHands.model.Contact;
import com.re.HelpingHands.model.Note;

import java.util.List;

public class NoteAdapter extends BaseAdapter {
    private List<Note> notes;
    private Context context;
    private LayoutInflater layoutInflater;

    public NoteAdapter(List<Note> notes, Context context) {
        this.notes = notes;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Note getItem(int i) {
        return notes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return notes.get(i).getId();
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = layoutInflater.inflate(R.layout.commentrow, viewGroup, false);
        }
        Note note = getItem(i);
        String image = note.getImage();
        try {
            if (image != null && !image.trim().isEmpty()) {
                ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
                int imageId = context.getResources().getIdentifier("com.re.HelpingHands:drawable/" + image, null, null);
                imageView.setImageDrawable(context.getResources().getDrawable(imageId));
            }
        } catch (Exception e) {
            System.out.println("Image not found, error :" + e.getMessage());
        }
        TextView noteView = (TextView) view.findViewById(R.id.textView);
        noteView.setText(note.getDescription());
        return view;
    }
}

