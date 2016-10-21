package com.example.khlopunov.contactslist;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 21.10.2016.
 */

public class ContactsProvider {
    public static final String CONTACT_PREFERENCES = "ContactsList";

    private static ContactsProvider sInstance;

    @NonNull
    private Hashtable<String, String> nameToContacts = new Hashtable<>();
    private List contactsName = new LinkedList();

    private ContactsProvider() {
    }

    public static ContactsProvider getInstance() {
        if (sInstance == null) {
            sInstance = new ContactsProvider();
        }
        return sInstance;
    }

    public List<Contact> addContacts() {
        List<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            contacts.add(new Contact(
                    "UserName" + i,
                    "8800555353" + i));

        }
        return contacts;
    }

    public boolean restoreData(@NonNull Context context) {
        SharedPreferences preferences = context.getSharedPreferences(CONTACT_PREFERENCES, Context.MODE_PRIVATE);
        boolean isExists = false;
        for (int i = 0; i < contactsName.size(); i++) {
            if (preferences.contains(contactsName.get(i).toString())) {
                isExists = true;
                if (!nameToContacts.contains(contactsName.get(i).toString())) {
                    String number = preferences.getString(contactsName.get(i).toString(), "");
                    nameToContacts.put(contactsName.get(i).toString(), number);
                }
            }
        }

        return isExists;
    }

    public boolean saveNumber(@NonNull Context context,
                              @NonNull String contactName,
                              @NonNull String contactNumber) {
        nameToContacts.put(contactName, contactNumber);
        SharedPreferences prefs = context.getSharedPreferences(CONTACT_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(contactName, contactNumber);

        return prefsEditor.commit();
    }

//        SharedPreferences preferences = context.getSharedPreferences(CONTACT_PREFERENCES, Context.MODE_PRIVATE);
//        for (int i = 0; i < 20; i++) {
//            SharedPreferences.Editor prefs = preferences.edit();
//            prefs.putString("UserName" + i, "880553535" + i);
//            prefs.commit();
}
