package com.star.smartcloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClosetActivity extends Activity {

    private Button AddClothesBtn;
    private Button OutfitsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closet);

        AddClothesBtn = (Button) findViewById(R.id.AddClothesBtn);
        AddClothesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClosetActivity.this, AddClothesActivity.class));
            }
        });

        OutfitsBtn = (Button) findViewById(R.id.OutfitsBtn);
        OutfitsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClosetActivity.this, OutfitsActivity.class));
                //finish();
            }
        });

    }
}
