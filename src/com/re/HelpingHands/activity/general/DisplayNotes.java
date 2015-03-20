package com.re.HelpingHands.activity.general;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.re.HelpingHands.R;
import com.re.HelpingHands.dao.DatabaseHelper;
import com.re.HelpingHands.dao.NoteDao;
import com.re.HelpingHands.model.Note;

import java.util.List;

public class DisplayNotes extends Activity {
    private NoteDao noteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note);
        noteDao = new NoteDao(new DatabaseHelper(this));
        refreshListView();
        addOnClickListenerOnList();

    }

    private void addOnClickListenerOnList() {
        ListView listView = (ListView) findViewById(R.id.notes);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, final long id) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(DisplayNotes.this);
                alertBuilder.setMessage("Are you sure you want to delete the selected note?");
                alertBuilder.setNegativeButton("Cancel", null);
                alertBuilder.setPositiveButton("Ok", new AlertDialog.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        noteDao.deleteNote((int) id);
                        refreshListView();
                        Toast.makeText(DisplayNotes.this, "Note deleted successfully", Toast.LENGTH_LONG).show();
                    }
                });
                alertBuilder.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            Intent i = new Intent();
            i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.general.AddNote");
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private void refreshListView() {
        List<Note> notes = noteDao.getAllNotes();
        System.out.println("Number of notes fetched : " + notes.size());
        ListView listView = (ListView) findViewById(R.id.notes);
        NoteAdapter noteAdapter = new NoteAdapter(notes, this);
        listView.setAdapter(noteAdapter);
    }

}
