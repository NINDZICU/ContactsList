package com.example.khlopunov.contactslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Admin on 19.10.2016.
 */

public class NumberFragment extends Fragment {
    private TextView numberContact;
    private Button btnSend;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        numberContact = (TextView) view.findViewById(R.id.tv_number);
        btnSend = (Button) view.findViewById(R.id.btn_send);
        Contact contact;

        if(getArguments()!=null){
            contact = (Contact) getArguments().getSerializable("contacts");
            numberContact.setText(contact.getNumber());
        }
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
