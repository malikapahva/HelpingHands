package com.re.HelpingHands.activity.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.*;
import com.re.HelpingHands.R;
import com.re.HelpingHands.dao.ContactDao;
import com.re.HelpingHands.dao.DatabaseHelper;
import com.re.HelpingHands.model.Contact;

public class EditContactInfo extends Activity {
    private ContactDao contactDao;
    private ContactGenerator contactGenerator;
    private long contactId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactDao = new ContactDao(new DatabaseHelper(this));
        contactGenerator = new ContactGenerator(this);
        setContentView(R.layout.addcontact);
        contactId = getIntent().getExtras().getLong("contactId");
        System.out.println("Contact id : " + contactId);
        Contact contact = contactDao.findContactById((int) contactId);
        if (contact != null) {
            updateContact(contact);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.savecancel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save) {
            Contact contactFromView = contactGenerator.generate();
            contactDao.updateContact((int)contactId, contactFromView);
            Toast.makeText(EditContactInfo.this, "Contact updated successfully", Toast.LENGTH_LONG).show();
            Intent i = new Intent();
            i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.contact.ContactInfo");
            startActivity(i);
        }
        if (item.getItemId() == R.id.cancel) {
            Intent i = new Intent();
            i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.contact.ContactInfo");
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateContact(Contact contact) {
        Spinner typeIn = (Spinner) findViewById(R.id.contacttype);
        int positionToSelect = ((ArrayAdapter<String>)typeIn.getAdapter()).getPosition(contact.getContactType());
        typeIn.setSelection(positionToSelect);
        EditText imageIn = (EditText) findViewById(R.id.image);
        imageIn.setText(contact.getImage());
        EditText nameIn = (EditText) findViewById(R.id.name);
        nameIn.setText(contact.getName());
        EditText relationIn = (EditText) findViewById(R.id.relation);
        relationIn.setText(contact.getRelation());
        EditText addressIn = (EditText) findViewById(R.id.address);
        addressIn.setText(contact.getAddress());
        EditText phoneIn = (EditText) findViewById(R.id.phone);
        phoneIn.setText(contact.getPhone());
        EditText emailIn = (EditText) findViewById(R.id.email);
        emailIn.setText(contact.getEmail());
    }
}
