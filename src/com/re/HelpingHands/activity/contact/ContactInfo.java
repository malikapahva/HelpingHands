package com.re.HelpingHands.activity.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.re.HelpingHands.R;
import com.re.HelpingHands.dao.ContactDao;
import com.re.HelpingHands.dao.DatabaseHelper;
import com.re.HelpingHands.model.Contact;

import java.util.List;

public class ContactInfo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        ContactDao contactDao = new ContactDao(new DatabaseHelper(this));
        List<Contact> contacts = contactDao.getAllContacts();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent displayContactIntent = new Intent();
                displayContactIntent.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.contact.DisplayContact");
                displayContactIntent.putExtra("contactId", id);
                startActivity(displayContactIntent);
            }
        });
        addContactsToList(contacts);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add, menu);
        return super.onCreateOptionsMenu(menu);

    }

    private void addContactsToList(List<Contact> contacts) {
        ListView listView = (ListView) findViewById(R.id.listView);
        ContactAdapter contactAdapter = new ContactAdapter(contacts, this);
        listView.setAdapter(contactAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            Intent i = new Intent();
            i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.contact.AddContact");
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
