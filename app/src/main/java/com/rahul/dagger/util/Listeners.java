package com.rahul.dagger.util;

import android.content.DialogInterface;

public class Listeners {

    public interface CommonListener {
        void onSuccess(Object o, Object o1);
        void onFailure(Object o);
    }

    public interface DialogListener {
        void onOkClick(DialogInterface dialog);
        void onCancelClick(DialogInterface dialog);
    }

    public interface CustomListener {
        void onOkClick(Object... obj);
        void onCancelClick(Object... obj);
    }


    public interface ItemClickListener {
        void onSelect(Object o, Object o1);
        void onUnSelect(Object o, Object o1);
    }

}