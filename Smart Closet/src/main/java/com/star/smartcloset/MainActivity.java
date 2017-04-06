package com.star.smartcloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends FragmentActivity {

    private Button logoutBtn;
    private Button styleBtn;
    private Button closetBtn;
    private Button eventsBtn;

    //private TextView todayStyleTxt;

    //private DatabaseReference DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user == null){
            startActivity(new Intent(this, SignInActivity.class));
            finish();
        }


        Toast.makeText(this, "Welcome "+user.getDisplayName()+" !", Toast.LENGTH_SHORT).show();
        logoutBtn = (Button) findViewById(R.id.LogoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AuthUI.getInstance()
                        .signOut(MainActivity.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
//                                AuthUI.getInstance()
//                                        .delete(MainActivity.this)
//                                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<Void> task) {
//                                        System.out.println("deleted");
//                                    }
//                                });
                                startActivity(new Intent(MainActivity.this, SignInActivity.class));
                                finish();
                            }
                        });
            }
        });
        eventsBtn = (Button) findViewById(R.id.EventsBtn);
        //todayStyleTxt = (TextView) findViewById(R.id.TodayStyleTxt);
        eventsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EventsActivity.class));
                //finish();
            }
        });

        //DB = FirebaseDatabase.getInstance().getReference();
        styleBtn = (Button) findViewById(R.id.StyleBtn);
        styleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StyleActivity.class));
                //finish();
            }
        });

        closetBtn = (Button) findViewById(R.id.ClosetBtn);
        closetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ClosetActivity.class));
                //finish();
            }
        });

    }
}
