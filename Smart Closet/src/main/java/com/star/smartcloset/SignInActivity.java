package com.star.smartcloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;


public class SignInActivity extends Activity {

    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth auth;
    private DatabaseReference DB_ref;
    //private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        auth = FirebaseAuth.getInstance();
        DB_ref = FirebaseDatabase.getInstance().getReference();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();

        } else {
            startSignIn();
        }

    }

    private void startSignIn(){
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build()))
                        .build(),
                RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_SIGN_IN) {
            if(resultCode == RESULT_OK){
                System.out.println("result ok");
                //DB_ref.setValue("Hello, World!");
                DB_ref.child("Users")
                        .child(auth.getCurrentUser().getUid().toString())
                            .child("email")
                               .setValue(auth.getCurrentUser().getEmail().toString());
                //IdpResponse response = IdpResponse.fromResultIntent(data);
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }else if(resultCode == RESULT_CANCELED){
                System.out.println("result cancelled");
                finishAffinity();
            }else{
                System.out.println("result else");
                startSignIn();
            }
        }
    }
}
