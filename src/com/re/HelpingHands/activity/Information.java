package com.re.HelpingHands.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.re.HelpingHands.R;

public class Information extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button personal = (Button) findViewById(R.id.personal);
        personal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.personal.DisplayPerson");
                startActivity(i);
            }
        });
        final Button contact = (Button) findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.contact.ContactInfo");
                startActivity(i);
            }
        });
        final Button general = (Button) findViewById(R.id.general);
        general.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.general.DisplayNotes");
                startActivity(i);
            }
        });
    }

}
