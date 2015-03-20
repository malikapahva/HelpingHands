package com.re.HelpingHands.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.re.HelpingHands.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteDao {
    private DatabaseHelper databaseHelper;
    public static final String TABLE_NAME = "note";
    private static final String NID = "id";
    private static final String IMAGE = "image";
    private static final String DESCRIPTION = "description";

    public static final String TABLE_CREATE =
            "Create table " + TABLE_NAME + "(" + NID + " INTEGER PRIMARY KEY autoincrement," + IMAGE + " TEXT ," +
                    DESCRIPTION + " TEXT );";

    public NoteDao(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void addNotes(Note note) {
        System.out.println("adding Note : " + note.getDescription());
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        updateContentValues(note, values);
        database.insert(TABLE_NAME, null, values);
        System.out.println("Note added Successfully......");
        database.close();
    }

    public void deleteNote(int id){
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        System.out.println("Deleting Note : " + id);
        database.delete(TABLE_NAME, NID + "=" + id, null);
        database.close();
    }

    private void updateContentValues(Note note, ContentValues values) {
        values.put(IMAGE, note.getImage());
        values.put(DESCRIPTION, note.getDescription());
    }

    public Note findNotesById(int id) {
        Cursor cursor = databaseHelper.getReadableDatabase().rawQuery("select * from " + TABLE_NAME + " where " + NID + "=" + id, null);
        try {
            if (cursor.moveToFirst()) {
                return fetchNotesFromCursor(cursor);
            }
            return null;
        } finally {
            cursor.close();
        }
    }

    public List<Note> getAllNotes() {
        List<Note> noteList = new ArrayList<Note>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Note note = fetchNotesFromCursor(cursor);
                    noteList.add(note);
                } while (cursor.moveToNext());
            }
            System.out.println("note list size : " + noteList.size());
            System.out.println("cursor size : " + cursor.getCount());
            return noteList;
        } finally {
            cursor.close();
        }
    }

    private Note fetchNotesFromCursor(Cursor cursor) {
        Note note = new Note(
                cursor.getString(cursor.getColumnIndex(IMAGE)),
                cursor.getString(cursor.getColumnIndex(DESCRIPTION))
        );
        note.setId(cursor.getInt(cursor.getColumnIndex(NID)));
        return note;
    }
}
