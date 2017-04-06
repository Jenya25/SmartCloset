package com.star.smartcloset;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OutfitsActivity extends Activity {

    private Button createOutfitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfits);

        createOutfitBtn = (Button) findViewById(R.id.CreateOutfitBtn);
        createOutfitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ToDo: Create new outfit
            }
        });
    }
}
