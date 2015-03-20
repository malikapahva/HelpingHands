package com.re.HelpingHands.activity.personal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.re.HelpingHands.R;
import com.re.HelpingHands.dao.DatabaseHelper;
import com.re.HelpingHands.dao.PersonalDao;
import com.re.HelpingHands.model.Person;

public class AddPersonDetail extends Activity{
    PersonalDao personalDao;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        personalDao = new PersonalDao(new DatabaseHelper(this));
        setContentView(R.layout.personaldetails);
        Person person = personalDao.getPerson();
        if(person != null){
            updatePerson(person);
        }

        final Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Person personInDB = personalDao.getPerson();
                Person personFromView = createPerson();
                if(personInDB != null){
                    personalDao.updatePerson(personInDB.getId(), personFromView);
                    Toast.makeText(AddPersonDetail.this, "Person updated successfully", Toast.LENGTH_LONG).show();
                }
                else{
                    personalDao.addPerson(personFromView);
                    Toast.makeText(AddPersonDetail.this, "Person added successfully", Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent();
                i.setClassName("com.re.HelpingHands", "com.re.HelpingHands.activity.personal.DisplayPerson");
                startActivity(i);
            }

            private Person createPerson() {
                EditText nameIn = (EditText) findViewById(R.id.name);
                String name = nameIn.getText().toString();
                EditText phoneIn = (EditText) findViewById(R.id.phone);
                String phone = phoneIn.getText().toString();
                EditText address1In = (EditText) findViewById(R.id.home);
                String address1 = address1In.getText().toString();
                EditText address2In = (EditText) findViewById(R.id.office);
                String address2 = address2In.getText().toString();
                EditText designationIn = (EditText) findViewById(R.id.designation);
                String designation = designationIn.getText().toString();
                EditText spouseIn = (EditText) findViewById(R.id.spouse);
                String spouse = spouseIn.getText().toString();
                EditText sphoneIn = (EditText) findViewById(R.id.spousePhone);
                String sphone = sphoneIn.getText().toString();
                EditText healthIn = (EditText) findViewById(R.id.health);
                String health = healthIn.getText().toString();
                EditText autoIn = (EditText) findViewById(R.id.auto);
                String auto = autoIn.getText().toString();
                EditText rentalIn = (EditText) findViewById(R.id.rental);
                String rental = rentalIn.getText().toString();
                EditText bdayIn = (EditText) findViewById(R.id.bday);
                String bday = bdayIn.getText().toString();
                EditText emailIn = (EditText) findViewById(R.id.email);
                String email = emailIn.getText().toString();
                EditText bloodIn = (EditText) findViewById(R.id.bloodGroup);
                String blood = bloodIn.getText().toString();
                return new Person(name, phone, address1, address2, designation, spouse,
                        sphone, health, auto, rental, bday, email, blood);
            }
        });

       }

    private void updatePerson(Person person) {
        EditText nameIn = (EditText) findViewById(R.id.name);
        nameIn.setText(person.getName());
        EditText phoneIn = (EditText) findViewById(R.id.phone);
        phoneIn.setText(person.getPhone());
        EditText address1In = (EditText) findViewById(R.id.home);
        address1In.setText(person.getHomeAddress());
        EditText address2In = (EditText) findViewById(R.id.office);
        address2In.setText(person.getOfficeAddress());
        EditText designationIn = (EditText) findViewById(R.id.designation);
        designationIn.setText(person.getDesignation());
        EditText spouseIn = (EditText) findViewById(R.id.spouse);
        spouseIn.setText(person.getSpouse());
        EditText sphoneIn = (EditText) findViewById(R.id.spousePhone);
        sphoneIn.setText(person.getSpousePhone());
        EditText healthIn = (EditText) findViewById(R.id.health);
        healthIn.setText(person.getHealthInsurance());
        EditText autoIn = (EditText) findViewById(R.id.auto);
        autoIn.setText(person.getAutoInsurance());
        EditText rentalIn = (EditText) findViewById(R.id.rental);
        rentalIn.setText(person.getRentalInsurance());
        EditText bdayIn = (EditText) findViewById(R.id.bday);
        bdayIn.setText(person.getBirthDate());
        EditText emailIn = (EditText) findViewById(R.id.email);
        emailIn.setText(person.getEmail());
        EditText bloodIn = (EditText) findViewById(R.id.bloodGroup);
        bloodIn.setText(person.getBloodGroup());
    }

}
