package com.re.HelpingHands.activity.contact;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Spinner;
import com.re.HelpingHands.R;
import com.re.HelpingHands.model.Contact;

public class ContactGenerator {
    private Activity activity;

    public ContactGenerator(Activity activity) {
        this.activity = activity;
    }

    public Contact generate() {
        Spinner typeIn = (Spinner) activity.findViewById(R.id.contacttype);
        String type = typeIn.getSelectedItem().toString();
        EditText imageIn = (EditText) activity.findViewById(R.id.image);
        String image = imageIn.getText().toString();
        EditText nameIn = (EditText) activity.findViewById(R.id.name);
        String name = nameIn.getText().toString();
        EditText relationIn = (EditText) activity.findViewById(R.id.relation);
        String relation = relationIn.getText().toString();
        EditText addressIn = (EditText) activity.findViewById(R.id.address);
        String address = addressIn.getText().toString();
        EditText phoneIn = (EditText) activity.findViewById(R.id.phone);
        String phone = phoneIn.getText().toString();
        EditText emailIn = (EditText) activity.findViewById(R.id.email);
        String email = emailIn.getText().toString();
        return new Contact(type,image, name, relation, phone, email, address);
    }
}
