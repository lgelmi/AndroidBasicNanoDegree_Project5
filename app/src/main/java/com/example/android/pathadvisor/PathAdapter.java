package com.example.android.pathadvisor;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PathAdapter extends ArrayAdapter<PathItem> {

    PathAdapter(Activity activity, ArrayList<PathItem> itemList) {
        super(activity, R.layout.list_item, itemList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        PathItem currentItem = getItem(position);
        fillItem(currentItem, listItemView, getContext());
        return listItemView;
    }

    static void fillItem(final PathItem item, View listItemView, final Context context){
        TextView itemName = listItemView.findViewById(R.id.item_name);
        //noinspection ConstantConditions
        itemName.setText(item.getItemName());
        ImageView image = listItemView.findViewById(R.id.item_image);
        if (item.getImageResourceId() != 0) {
            image.setImageResource(item.getAvatarResourceId());
            image.setVisibility(View.VISIBLE);
        } else
            image.setVisibility(View.INVISIBLE);
        ImageView categoryImage = listItemView.findViewById(R.id.item_icon);
        if (item.getIconResourceId() != 0) {
            categoryImage.setImageResource(item.getIconResourceId());
            categoryImage.setVisibility(View.VISIBLE);
        } else
            categoryImage.setVisibility(View.INVISIBLE);
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(context, DetailsActivity.class)
                        .putExtra(context.getString(R.string.path_item_name), item);
                context.startActivity(detailIntent);
            }
        });

        listItemView.setBackgroundColor(
                ContextCompat.getColor(context, item.getColorId()));

    }

}
