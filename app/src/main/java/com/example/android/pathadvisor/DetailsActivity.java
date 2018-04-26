package com.example.android.pathadvisor;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        try {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        // Get all view item
        View mainLayout = findViewById(R.id.main_layout);
        TextView name = findViewById(R.id.item_name);
        ImageView image = findViewById(R.id.item_image);
        TextView description = findViewById(R.id.item_description);
        View ownerLayout = findViewById(R.id.owner_layout);
        View ownerItem = findViewById(R.id.owner_item);
        // Extract values from class
        PathItem detailItem = getIntent().getExtras().getParcelable(this.getString(R.string.path_item_name));
        String detailName = detailItem.getItemName();
        int imageId = detailItem.getImageResourceId();
        String detailDescription = detailItem.getDescription();
        PathItem detailOwner = detailItem.getOwner();
        // Sets the view values
        mainLayout.setBackgroundColor(
                ContextCompat.getColor(this, detailItem.getColorId()));

        name.setText(detailName);
        if (imageId == 0)
            image.setVisibility(View.GONE);
        else {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(imageId);
        }
        if (detailDescription == null || detailDescription.length() == 0)
            description.setVisibility(View.GONE);
        else {
            description.setVisibility(View.VISIBLE);
            description.setText(detailItem.getDescription());
        }
        if (detailOwner == null)
            ownerLayout.setVisibility(View.GONE);
        else {
            ownerLayout.setVisibility(View.VISIBLE);
            ownerLayout.setBackgroundColor(
                    ContextCompat.getColor(this, detailOwner.getColorId()));
            PathAdapter.fillItem(detailOwner, ownerItem, this);
        }
    }

}
