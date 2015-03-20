package com.re.HelpingHands.activity.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.re.HelpingHands.R;
import com.re.HelpingHands.dao.ContactDao;
import com.re.HelpingHands.dao.DatabaseHelper;
import com.re.HelpingHands.model.Contact;

public class AddContact extends Activity {
    private ContactDao contactDao;
    private ContactGenerator contactGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactDao = new ContactDao(new DatabaseHelper(this));
        contactGenerator = new ContactGenerator(this);
        setContentView(R.layout.addcontact);
        Spinner spinner = (Spinner) findViewById(R.id.contacttype);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.contacts, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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
            Contact contactFromView = contactGenerator.generate();
            contactDao.addContact(contactFromView);
            Toast.makeText(this, "Contact added successfully", Toast.LENGTH_LONG).show();
            Intent i = new Intent();
            i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.contact.ContactInfo");
            startActivity(i);
        }
        if (item.getItemId() == R.id.cancel){
            Intent i = new Intent();
            i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.contact.ContactInfo");
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}

