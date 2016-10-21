package com.example.khlopunov.contactslist;

import android.app.*;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick {
    private RecyclerView rv;
    private static List<Contact> contacts;
    private static List<Contact> deleteContacts;
    public static boolean isBigMode;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContactsProvider.getInstance().restoreData(this);

        deleteContacts = new LinkedList<>();

//        contacts = addContacts();

//        rv = (RecyclerView) findViewById(R.id.rv);
//        viewPager = (ViewPager) findViewById(R.id.view_pager);
//        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
//        ContactsAdapter adapter = new ContactsAdapter(MainActivity.this, contacts);
//        rv.setAdapter(adapter);
        isBigMode = (findViewById(R.id.frame_layout_info) != null);

            Fragment fragment = new RecyclerFragment();
            Bundle bundle = new Bundle();

//            bundle.putSerializable("contacts", (Serializable) contacts);
            bundle.putSerializable("deleteContacts", (Serializable) deleteContacts);
            fragment.setArguments(bundle);
        if(!isBigMode) {
            getFragmentManager().beginTransaction().replace(
                    R.id.frame_layout_portrait, fragment, RecyclerFragment.class.getName()).commit();
        }
        else{
            getFragmentManager().beginTransaction().replace(
                    R.id.recycler_frame_layout, fragment, RecyclerFragment.class.getName()).commit();

        }
//        isLandscape = false;
//        if (findViewById(R.id.frame_layout_portrait) != null) {
//            RecyclerFragment recyclerFragment = new RecyclerFragment();
//            getFragmentManager().beginTransaction().replace(R.id.frame_layout_portrait, recyclerFragment,
//                    RecyclerFragment.class.getName()).commit();
//        }
//        if (findViewById(R.id.frame_layout) != null) {
//            isLandscape = true;
//            ContactInformationFragment contactInformationFragment = new ContactInformationFragment();
//            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, contactInformationFragment,
//                    ContactInformationFragment.class.getName()).commit();
//        }
//        adapter.setListener(new OnItemClick() {
//            @Override
//            public void OnItemClick(Contact contact) {
//                if (isLandscape) {
//                    NumberFragment numberFragment = new NumberFragment();
//                    Bundle bundle = new Bundle();
//                    bundle.putParcelable("contact", (Parcelable) contact);
//                    numberFragment.setArguments(bundle);
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_portrait, numberFragment, NumberFragment.class.getSimpleName()).commit();
//                } else {
////            Intent intent = new Intent(MainActivity.this, InformationActivity.class);
////            contact.fillIntent(intent);
////            startActivity(intent);
//                }
//            }
//
//            @Override
//            public void OnDeleteContactClick(Contact contact) {
//                deleteContacts.add(contact);
//                DeleteFragment deleteFragment = new DeleteFragment();
//                Bundle bundle = new Bundle();
//                bundle.putParcelableArrayList("contacts", deleteContacts);
//                deleteFragment.setArguments(bundle);
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_portrait, deleteFragment, NumberFragment.class.getSimpleName()).commit();
//                if(isPortrait) {
//                    mFrameLayout.setVisibility(View.VISIBLE);
//                    mRecyclerView.setVisibility(View.INVISIBLE);
//                }
//            }
//        });


    }

//    private LinkedList<Contact> addContacts() {
//        LinkedList<Contact> contacts = new LinkedList<>();
//        for (int i = 0; i < 20; i++) {
//            Contact contact = new Contact(
//                    "Username" + i,
//                    "8800555353" + i
//            );
//            contacts.add(contact);
//        }
//        return contacts;
//    }

    @Override
    public void OnItemClick(Contact contact) {
        Fragment fragment = new NumberFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("contacts", contact);
        fragment.setArguments(bundle);
        if (isBigMode) {
            getFragmentManager().beginTransaction().replace(R.id.frame_layout_info, fragment, NumberFragment.class.getSimpleName()).commit();
        } else {
            getFragmentManager().beginTransaction().replace(R.id.frame_layout_portrait, fragment, NumberFragment.class.getSimpleName()).addToBackStack(null).commit();
        }
    }

    @Override
    public void OnLongClick(Contact contact) {
        DialogFragment dialog = new com.example.khlopunov.contactslist.DialogFragment();
//        dialog.setInformation(contacts, deletedContacts, position, adapter);
        dialog.show(getFragmentManager(), com.example.khlopunov.contactslist.DialogFragment.class.getName());
    }


}
