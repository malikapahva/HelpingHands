package com.re.HelpingHands.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.re.HelpingHands.model.Person;

public class PersonalDao  {
    private DatabaseHelper databaseHelper;
    public static final String TABLE_NAME = "personal";
    public static final String PID = "id";
    public static final String NAME = "name";
    private static final String PHONE = "phone";
    private static final String ADDRESS1 = "homeAddress";
    private static final String ADDRESS2 = "officeAddress";
    private static final String DESIGNATION = "designation";
    private static final String SPOUSE = "spouse";
    private static final String SPHONE = "spousePhone";
    private static final String HEALTH = "healthInsurance";
    private static final String AUTO = "autoInsurance";
    private static final String RENTAL = "rentalInsurance";
    private static final String BDAY = "birthDate";
    private static final String EMAIL = "email";
    private static final String BLOOD = "bloodGroup";

    public static final String TABLE_CREATE =
            "Create table " + TABLE_NAME + "(" + PID + " INTEGER PRIMARY KEY," +
                    NAME + " TEXT , " + PHONE + " TEXT ," + ADDRESS1 + " TEXT ," + ADDRESS2 + " TEXT ," +
                    DESIGNATION + " TEXT ," + SPOUSE + " TEXT ," + SPHONE + " TEXT ," + HEALTH + " TEXT ," +
                    AUTO + " TEXT ," + RENTAL + " TEXT ," + BDAY + " TEXT ," + EMAIL + " TEXT ," + BLOOD + " TEXT );";

    public PersonalDao(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void addPerson(Person person) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PID, 1);
        updateContentValues(person, values);
        database.insert(TABLE_NAME, null, values);
        database.close();
    }

    private void updateContentValues(Person person, ContentValues values) {
        values.put(NAME, person.getName());
        values.put(PHONE, person.getPhone());
        values.put(ADDRESS1, person.getHomeAddress());
        values.put(ADDRESS2, person.getOfficeAddress());
        values.put(DESIGNATION, person.getDesignation());
        values.put(SPOUSE, person.getSpouse());
        values.put(SPHONE, person.getSpousePhone());
        values.put(HEALTH, person.getHealthInsurance());
        values.put(AUTO, person.getAutoInsurance());
        values.put(RENTAL, person.getRentalInsurance());
        values.put(BDAY, person.getBirthDate());
        values.put(EMAIL, person.getEmail());
        values.put(BLOOD, person.getBloodGroup());
    }

    public Person getPerson() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String[] columns = {PID, NAME, PHONE, ADDRESS1, ADDRESS2, DESIGNATION,
                SPOUSE, SPHONE, HEALTH, AUTO, RENTAL, BDAY, EMAIL, BLOOD};

        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
        try {
            if (cursor.getCount() > 0) {
                cursor.moveToLast();

                Person person = new Person(cursor.getString(cursor.getColumnIndex(NAME)),
                        cursor.getString(cursor.getColumnIndex(PHONE)), cursor.getString(cursor.getColumnIndex(ADDRESS1)),
                        cursor.getString(cursor.getColumnIndex(ADDRESS2)), cursor.getString(cursor.getColumnIndex(DESIGNATION)),
                        cursor.getString(cursor.getColumnIndex(SPOUSE)), cursor.getString(cursor.getColumnIndex(SPHONE)),
                        cursor.getString(cursor.getColumnIndex(HEALTH)), cursor.getString(cursor.getColumnIndex(AUTO)),
                        cursor.getString(cursor.getColumnIndex(RENTAL)), cursor.getString(cursor.getColumnIndex(BDAY)),
                        cursor.getString(cursor.getColumnIndex(EMAIL)), cursor.getString(cursor.getColumnIndex(BLOOD))
                );
                person.setId(cursor.getInt(cursor.getColumnIndex(PID)));
                return person;
            }
            return null;
        } finally {
            cursor.close();
        }
    }

    public void updatePerson(int personId, Person newPersonDetail) {
        ContentValues values = new ContentValues();
        updateContentValues(newPersonDetail, values);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        database.update(TABLE_NAME, values, PID + " = " + personId, null);
        database.close();
    }
}
