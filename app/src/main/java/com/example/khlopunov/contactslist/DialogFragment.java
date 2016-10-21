package com.example.khlopunov.contactslist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Admin on 21.10.2016.
 */

public class DialogFragment extends android.app.DialogFragment implements DialogInterface.OnClickListener {
    private Context context;
    private TextView tv_text;
    private Button btn_yes;
    private Button btn_no;


//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.dialog_fragment_delete, container, false);
//        return view;
//    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder adb = new AlertDialog.Builder (getActivity()).setTitle("Delete number?").
                setNegativeButton("No", this).setPositiveButton("Yes", this)
                .setMessage("Вы не сможете отменить это действие");
        return adb.create();

    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        btn_yes = (Button) view.findViewById(R.id.btn_yes);
//        btn_no = (Button) view.findViewById(R.id.btn_no);
//
//    }


    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
            case Dialog.BUTTON_POSITIVE:

                dismiss();
                break;
            case Dialog.BUTTON_NEGATIVE:
                dismiss();
                break;
        }


    }
}
