package com.example.khlopunov.contactslist;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 19.10.2016.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {
    private static List<Contact> contacts;
    Context context;
    private OnItemClick listener;
    NumberFragment numberFragment;


    public ContactsAdapter(LinkedList<Contact> contacts) {
        this.contacts = contacts;
    }

    public ContactsAdapter(Context context, LinkedList<Contact> contacts) {
        this.contacts = contacts;
        this.context = context;
    }

    public void setListContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public void setListener(OnItemClick listener) {
        this.listener = listener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.contacts_layout,
                parent,
                false
        );
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, final int position) {
        addContacts();
        final Contact contact = contacts.get(position);

//        holder.ivContact.setImageDrawable(context.getResources().getDrawable(contacts.get(position)));
        holder.nameContact.setText(contact.getName());
        holder.numberContact.setText(contact.getNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnItemClick(contact);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.OnLongClick(contact);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        ImageView ivContact;
        TextView nameContact;
        TextView numberContact;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ivContact = (ImageView) itemView.findViewById(R.id.iv_photo_contact);
            nameContact = (TextView) itemView.findViewById(R.id.tv_name);
            numberContact = (TextView) itemView.findViewById(R.id.tv_number);
        }

    }
    private LinkedList<Contact> addContacts() {
        LinkedList<Contact> contacts = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            Contact contact = new Contact(
                    "Username" + i,
                    "8800555353" + i
            );
            contacts.add(contact);
        }
        return contacts;
    }
}
