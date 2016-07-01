package com.artes.alexbispo.showrandomcontact;

import android.annotation.SuppressLint;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;

/**
 * Created by alex on 01/07/16.
 */
public class ContactsLoaderCallbacks implements LoaderManager.LoaderCallbacks<Cursor> {

    @SuppressLint("InlinedApi")
    private static final String[] PROJECTION =
            {
                    ContactsContract.Contacts._ID,
                    ContactsContract.Contacts.LOOKUP_KEY,
                    Build.VERSION.SDK_INT
                            >= Build.VERSION_CODES.HONEYCOMB ?
                            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY :
                            ContactsContract.Contacts.DISPLAY_NAME

            };


    private MainActivity mActivity;

    public ContactsLoaderCallbacks(){}

    public ContactsLoaderCallbacks(MainActivity mainActivity) {
        mActivity = mainActivity;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // Starts the query
        return new CursorLoader(
                mActivity,
                ContactsContract.Contacts.CONTENT_URI,
                PROJECTION,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        int count = data.getCount();
        mActivity.showCount(count);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
