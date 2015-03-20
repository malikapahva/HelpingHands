package com.re.HelpingHands.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.re.HelpingHands.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactDao {
   private DatabaseHelper databaseHelper;
    public static final String TABLE_NAME = "contact";
    private static final String CID = "id";
    private static final String TYPE = "contacttype";
    private static final String IMAGE = "image";
    private static final String NAME = "name";
    private static final String RELATION = "relation";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";

    public static final String TABLE_CREATE =
            "Create table " + TABLE_NAME + "(" + CID + " INTEGER PRIMARY KEY autoincrement," + IMAGE + " TEXT ," +
                    TYPE + " TEXT , " + NAME + " TEXT , " + RELATION + " TEXT , " + ADDRESS + " TEXT ," + PHONE + " TEXT ," +
                    EMAIL + " TEXT );";

    public ContactDao(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void addContact(Contact contact) {
        System.out.println("adding Contact : " + contact.getName());
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        updateContentValues(contact, values);
        database.insert(TABLE_NAME, null, values);
        System.out.println("Contact added Successfully......");
        database.close();
    }

    private void updateContentValues(Contact contact, ContentValues values) {
        values.put(TYPE, contact.getContactType());
        values.put(IMAGE, contact.getImage());
        values.put(NAME, contact.getName());
        values.put(RELATION, contact.getRelation());
        values.put(ADDRESS, contact.getAddress());
        values.put(PHONE, contact.getPhone());
        values.put(EMAIL, contact.getEmail());
    }

    public Contact findContactById(int id) {
        Cursor cursor = databaseHelper.getReadableDatabase().rawQuery("select * from " + TABLE_NAME + " where " + CID + "=" + id, null);
        try {
            if (cursor.moveToFirst()) {
                return fetchContactFromCursor(cursor);
            }
            return null;
        } finally {
            cursor.close();
        }
    }

    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Contact contact = fetchContactFromCursor(cursor);
                    contactList.add(contact);
                } while (cursor.moveToNext());
            }
            System.out.println("contact list size : " + contactList.size());
            System.out.println("cursor size : " + cursor.getCount());
            return contactList;
        } finally {
            cursor.close();
        }
    }

    public void updateContact(int contactId, Contact newContactDetail) {
        ContentValues values = new ContentValues();
        updateContentValues(newContactDetail, values);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        database.update(TABLE_NAME, values, CID + " = " + contactId, null);
        database.close();
    }

    private Contact fetchContactFromCursor(Cursor cursor){
        Contact contact = new Contact(
                cursor.getString(cursor.getColumnIndex(TYPE)),
                cursor.getString(cursor.getColumnIndex(IMAGE)),
                cursor.getString(cursor.getColumnIndex(NAME)),
                cursor.getString(cursor.getColumnIndex(RELATION)),
                cursor.getString(cursor.getColumnIndex(PHONE)),
                cursor.getString(cursor.getColumnIndex(EMAIL)),
                cursor.getString(cursor.getColumnIndex(ADDRESS))
                );
        contact.setId(cursor.getInt(cursor.getColumnIndex(CID)));
        return contact;
    }
}
