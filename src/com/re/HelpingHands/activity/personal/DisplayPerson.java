package com.re.HelpingHands.activity.personal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.re.HelpingHands.R;
import com.re.HelpingHands.dao.DatabaseHelper;
import com.re.HelpingHands.dao.PersonalDao;
import com.re.HelpingHands.model.Person;

public class DisplayPerson extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showpersonaldetail);
        PersonalDao personalDao = new PersonalDao(new DatabaseHelper(this));
        Person person = personalDao.getPerson();
        if (person != null) {
            updatePersonDetail(person);
        }
        final Button add = (Button) findViewById(R.id.addedit);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.personal.AddPersonDetail");
                startActivity(i);
            }
        });
    }

    private void updatePersonDetail(Person person) {
        TextView name = (TextView) findViewById(R.id.vname);
        name.setText(person.getName());
        TextView phone = (TextView) findViewById(R.id.vphone);
        phone.setText(person.getPhone());
        TextView home = (TextView) findViewById(R.id.vhome);
        home.setText(person.getHomeAddress());
        TextView office = (TextView) findViewById(R.id.voffice);
        office.setText(person.getOfficeAddress());
        TextView designation = (TextView) findViewById(R.id.vdesignation);
        designation.setText(person.getDesignation());
        TextView spouse = (TextView) findViewById(R.id.vspouse);
        spouse.setText(person.getSpouse());
        TextView sphone = (TextView) findViewById(R.id.vsphone);
        sphone.setText(person.getSpousePhone());
        TextView health = (TextView) findViewById(R.id.vhealth);
        health.setText(person.getHealthInsurance());
        TextView auto = (TextView) findViewById(R.id.vauto);
        auto.setText(person.getAutoInsurance());
        TextView rental = (TextView) findViewById(R.id.vrental);
        rental.setText(person.getRentalInsurance());
        TextView bday = (TextView) findViewById(R.id.vbday);
        bday.setText(person.getBirthDate());
        TextView email = (TextView) findViewById(R.id.vemail);
        email.setText(person.getEmail());
        TextView blood = (TextView) findViewById(R.id.vblood);
        blood.setText(person.getBloodGroup());
    }
}


