package com.star.smartcloset;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class AddClothesActivity extends Activity {

    //image
    private StorageReference mStorageRef;


    //spinners
    private Spinner categoriesSpinner;
    private Spinner sleeveLengthSpinner;
    private Spinner itemLengthSpinner;
    private Spinner fabricSpinner;
    private Spinner shoesSpinner;
    //layouts
    private LinearLayout currentLayout;
    private LinearLayout fieldsLayout;
    private LinearLayout tops;
    private LinearLayout sweaters;
    private LinearLayout bottoms;
    private LinearLayout dresses;
    private LinearLayout coats;
    private LinearLayout shoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothes);

        //region Layouts
        //-----------------------------------------------------------------------------------------
        fieldsLayout = (LinearLayout) findViewById(R.id.FieldsLayout);
        tops = (LinearLayout) findViewById(R.id.topsBlousesTshirts);
        sweaters = (LinearLayout) findViewById(R.id.sweaters);
        bottoms = (LinearLayout) findViewById(R.id.bottomsSkirts);
        dresses = (LinearLayout) findViewById(R.id.dressesOveralls);
        coats = (LinearLayout) findViewById(R.id.coatsJackets);
        shoes = (LinearLayout) findViewById(R.id.shoes);
        //-----------------------------------------------------------------------------------------
        //endregion

        //region Image
        //-----------------------------------------------------------------------------------------
        mStorageRef = FirebaseStorage.getInstance().getReference();


        Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));
        StorageReference riversRef = mStorageRef.child("images/rivers.jpg");

        riversRef.putFile(file)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        @SuppressWarnings("VisibleForTests") Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });

        //-----------------------------------------------------------------------------------------
        //endregion

        //region Category Spinner
        //-----------------------------------------------------------------------------------------
        categoriesSpinner = ((Spinner)findViewById(R.id.categories));
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,
                R.array.AddClothes_category_array, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoriesSpinner.setAdapter(categoryAdapter);


        categoriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String category = (String) parent.getItemAtPosition(position);
                switch (category){
                    case "Tops, Blouses & T-shirts":
                        if(currentLayout != null){
                            currentLayout.setVisibility(View.GONE);
                        }
                        fieldsLayout.setVisibility(View.VISIBLE);
                        tops.setVisibility(View.VISIBLE);
                        currentLayout = tops;
                        break;
                    case "Sweaters":
                        if(currentLayout != null){
                            currentLayout.setVisibility(View.GONE);
                        }
                        currentLayout = sweaters;
                        fieldsLayout.setVisibility(View.VISIBLE);
                        sweaters.setVisibility(View.VISIBLE);
                        break;
                    case "Bottoms & Skirts":
                        if(currentLayout != null){
                            currentLayout.setVisibility(View.GONE);
                        }
                        fieldsLayout.setVisibility(View.VISIBLE);
                        bottoms.setVisibility(View.VISIBLE);
                        currentLayout = bottoms;
                        break;
                    case "Dresses & Overalls":
                        if(currentLayout != null){
                            currentLayout.setVisibility(View.GONE);
                        }
                        fieldsLayout.setVisibility(View.VISIBLE);
                        dresses.setVisibility(View.VISIBLE);
                        currentLayout = dresses;
                        break;
                    case "Coats & Jackets":
                        if(currentLayout != null){
                            currentLayout.setVisibility(View.GONE);
                        }
                        fieldsLayout.setVisibility(View.VISIBLE);
                        coats.setVisibility(View.VISIBLE);
                        currentLayout = coats;
                        break;
                    case "Shoes":
                        if(currentLayout != null){
                            currentLayout.setVisibility(View.GONE);
                        }
                        fieldsLayout.setVisibility(View.VISIBLE);
                        shoes.setVisibility(View.VISIBLE);
                        currentLayout = shoes;
                        break;
                    default:
                        if(currentLayout != null){
                            currentLayout.setVisibility(View.GONE);
                            currentLayout = null;
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if(currentLayout != null){
                    currentLayout.setVisibility(View.GONE);
                    currentLayout = null;
                }
            }
        });

        //-----------------------------------------------------------------------------------------
        //endregion

        //region Sleeve Length Spinner
        //-----------------------------------------------------------------------------------------
        sleeveLengthSpinner = ((Spinner)findViewById(R.id.sleeveLengthField));
        ArrayAdapter<CharSequence> sleeveLengthAdapter = ArrayAdapter.createFromResource(this,
                R.array.AddClothes_sleeveLength_array, android.R.layout.simple_spinner_item);
        sleeveLengthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sleeveLengthSpinner.setAdapter(sleeveLengthAdapter);


        sleeveLengthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sleeveLength = (String) parent.getItemAtPosition(position);
                switch (sleeveLength){
                    case "Sleeveless":
                        break;
                    case "Cap Sleeve":
                        break;
                    case "Short Sleeve":
                        break;
                    case "Three-quarter Sleeve":
                        break;
                    case "Long Sleeve":
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //if nothing selected
            }
        });

        //-----------------------------------------------------------------------------------------
        //endregion

        //region Item Length Spinner
        //-----------------------------------------------------------------------------------------
        itemLengthSpinner = ((Spinner)findViewById(R.id.itemLengthField));
        ArrayAdapter<CharSequence> itemLengthAdapter = ArrayAdapter.createFromResource(this,
                R.array.AddClothes_itemLength_array, android.R.layout.simple_spinner_item);
        itemLengthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemLengthSpinner.setAdapter(itemLengthAdapter);


        itemLengthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemLength = (String) parent.getItemAtPosition(position);
                switch (itemLength){
                    case "Short":
                        break;
                    case "Medium length":
                        break;
                    case "Three-quarter":
                        break;
                    case "Long":
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //if nothing selected
            }
        });

        //-----------------------------------------------------------------------------------------
        //endregion

        //region Fabric Spinner
        //-----------------------------------------------------------------------------------------
        fabricSpinner = ((Spinner)findViewById(R.id.fabricField));
        ArrayAdapter<CharSequence> fabricAdapter = ArrayAdapter.createFromResource(this,
                R.array.AddClothes_fabric_array, android.R.layout.simple_spinner_item);
        fabricAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fabricSpinner.setAdapter(fabricAdapter);


        fabricSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String fabric = (String) parent.getItemAtPosition(position);
                switch (fabric){
                    case "Cotton":
                        break;
                    case "Denim":
                        break;
                    case "Fur / Faux Fur":
                        break;
                    case "Lace / Net":
                        break;
                    case "Leather / Sintetic Leather":
                        break;
                    case "Polyester":
                        break;
                    case "Satin":
                        break;
                    case "Silk":
                        break;
                    case "Velvet":
                        break;
                    case "Viscose":
                        break;
                    case "Wool / Yarn":
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //if nothing selected
            }
        });

        //-----------------------------------------------------------------------------------------
        //endregion

        //region Shoes Type Spinner
        //-----------------------------------------------------------------------------------------
        shoesSpinner = ((Spinner)findViewById(R.id.shoesTypeField));
        ArrayAdapter<CharSequence> shoesAdapter = ArrayAdapter.createFromResource(this,
                R.array.AddClothes_shoesType_array, android.R.layout.simple_spinner_item);
        shoesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shoesSpinner.setAdapter(shoesAdapter);


        shoesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String shoes = (String) parent.getItemAtPosition(position);
                switch (shoes){
                    case "Flats":
                        break;
                    case "Low heels":
                        break;
                    case "High heels":
                        break;
                    case "Boots":
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //if nothing selected
            }
        });

        //-----------------------------------------------------------------------------------------
        //endregion



    }
}
