package com.star.smartcloset;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventsActivity extends Activity {

    private Button createEventBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        createEventBtn = (Button) findViewById(R.id.CreateEventBtn);
        createEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ToDo: Create new Event
            }
        });
    }
}
