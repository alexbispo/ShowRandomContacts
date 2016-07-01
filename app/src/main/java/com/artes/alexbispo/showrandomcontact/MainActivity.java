package com.artes.alexbispo.showrandomcontact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mCountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCountText = (TextView) findViewById(R.id.contacts_count_text);

        ContactsLoaderCallbacks callbacks = new ContactsLoaderCallbacks(this);
        getLoaderManager().initLoader(0, null, callbacks);
    }

    public void showCount(int count) {
        mCountText.setText(count + "");
    }
}
