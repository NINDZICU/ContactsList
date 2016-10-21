package com.example.khlopunov.contactslist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 20.10.2016.
 */

public class RecyclerFragment extends Fragment {
    RecyclerView rv;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected ContactsAdapter contactsAdapter;
    private List<Contact> contacts;
    private OnItemClick listener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contacts = new LinkedList<>();
        View view = inflater.inflate(R.layout.recycler_main, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);
        if(getArguments() != null){
            contacts = (List<Contact>) getArguments().getSerializable("contacts");
        }
        contactsAdapter = new ContactsAdapter((LinkedList<Contact>) contacts);
        contactsAdapter.setListContacts(ContactsProvider.getInstance().addContacts());
        contactsAdapter.setListener(listener);
        rv.setAdapter(contactsAdapter);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnItemClick) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        contacts = addContacts();
//        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
//        ContactsAdapter adapter = new ContactsAdapter(RecyclerFragment.this, contacts);
//        rv.setAdapter(adapter);
////
////        if(getArguments()!=null){
////            Contact contact = getArguments().getParcelable("contact");
////            numberContact.setText(getArguments().getString(contact.getNumber()));
    }

}

