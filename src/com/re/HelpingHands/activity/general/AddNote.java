package com.re.HelpingHands.activity.general;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import com.re.HelpingHands.R;
import com.re.HelpingHands.dao.DatabaseHelper;
import com.re.HelpingHands.dao.NoteDao;
import com.re.HelpingHands.model.Note;

public class AddNote extends Activity {
    private NoteDao noteDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noteDao = new NoteDao(new DatabaseHelper(this));
        setContentView(R.layout.addnote);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.savecancel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("Button clicked :" + item.getItemId());
        System.out.println("Save Id : " + R.id.save + ", Cancel Id : " + R.id.cancel );
        if (item.getItemId() == R.id.save) {
            Note noteFromView = noteGenerator();
            noteDao.addNotes(noteFromView);
            Toast.makeText(this, "Note added successfully", Toast.LENGTH_LONG).show();
            Intent i = new Intent();
            i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.general.DisplayNotes");
            startActivity(i);
        }
        if (item.getItemId() == R.id.cancel){
            Intent i = new Intent();
            i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.general.DisplayNotes");
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private Note noteGenerator(){
        EditText imageIn = (EditText) findViewById(R.id.noteimage);
        String image = imageIn.getText().toString();
        EditText descIn = (EditText) findViewById(R.id.notedescription);
        String desc = descIn.getText().toString();
        return new Note(image, desc);
    }
}
