package com.re.HelpingHands.activity.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.re.HelpingHands.model.Contact;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private List<Contact> contacts;
    private Context context;
    private LayoutInflater layoutInflater;

    public ContactAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Contact getItem(int i) {
        return contacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return contacts.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = layoutInflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        }
        Contact contact = getItem(i);
        TextView contactView = (TextView) view.findViewById(android.R.id.text1);
        contactView.setText(contact.getContactType() + " :\n" + contact.getName());
        return view;
    }
}
