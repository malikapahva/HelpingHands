package com.re.HelpingHands.activity.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.re.HelpingHands.R;
import com.re.HelpingHands.dao.ContactDao;
import com.re.HelpingHands.dao.DatabaseHelper;
import com.re.HelpingHands.model.Contact;

public class DisplayContact extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaycontact);
        final long contactId = getIntent().getExtras().getLong("contactId");
        ContactDao contactDao = new ContactDao(new DatabaseHelper(this));
        Contact contact = contactDao.findContactById((int) contactId);
        if (contact != null) {
            updateContactDetail(contact);
        }

        final Button edit = (Button) findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.contact.EditContactInfo");
                i.putExtra("contactId", contactId);
                startActivity(i);
            }
        });
    }

    private void updateContactDetail(Contact contact) {
        try {
            String image = contact.getImage();
            if (image != null && !image.trim().isEmpty()) {
                ImageView imageView = (ImageView) findViewById(R.id.image);
                int imageId = getResources().getIdentifier("com.re.HelpingHands:drawable/" + image, null, null);
                imageView.setImageDrawable(getResources().getDrawable(imageId));
            }
        } catch (Exception e) {
            System.out.println("Image not found, error message :" + e.getMessage());
        }
        TextView name = (TextView) findViewById(R.id.vname);
        name.setText(contact.getName());
        TextView relation = (TextView) findViewById(R.id.vrelation);
        relation.setText(contact.getRelation());
        TextView address = (TextView) findViewById(R.id.vaddress);
        address.setText(contact.getAddress());
        TextView phone = (TextView) findViewById(R.id.vphone);
        phone.setText(contact.getPhone());
        TextView email = (TextView) findViewById(R.id.vemail);
        email.setText(contact.getEmail());

    }

}
