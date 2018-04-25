package com.example.android.pathadvisor;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.ArrayList;

public class PathItem implements Comparable<PathItem>, Parcelable{

    // Name to be displayed for this item
    private String itemName;
    // Image representing the item
    private int imageResourceId;
    // Small image representing the item
    private int avatarResourceId;
    // The item description
    private String description;
    // The list of possible categories
    protected enum categories{
        NONE, CHARACTER, CITY, INN, POI, SHOP
    }
    // This instance category
    private categories category = categories.NONE;
    // Item owners. Just one to avoid the need to add a listview also to the details.
    // A lot of other relations might be defined, but the current data structure would lead to
    // circular references... (A global variable might suffice, but this would be represented quite
    // well by a relational database!)
    private PathItem owner;

    // A fast-essential constructor
    PathItem(String itemName, categories category) {
        setItemName(itemName);
        setCategory(category);
    }

    // The main constructor needs all data to be to the very least correctly displayed
    PathItem(String itemName, int imageResourceId, categories category) {
        setItemName(itemName);
        setImageResourceId(imageResourceId);
        setCategory(category);
    }

    public String getItemName() {
        if (itemName == null)
            return "";
        else
            return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getAvatarResourceId() {
        // If a smaller image is not available, use the standard one as preview
        if (avatarResourceId != 0)
            return avatarResourceId;
        else
            return getImageResourceId();
    }

    public void setAvatarResourceId(int avatarResourceId) {
        this.avatarResourceId = avatarResourceId;
    }

    public int getIconResourceId() {
        switch (category){
            case CHARACTER:
                return R.drawable.pg;
            case CITY:
                return R.drawable.village;
            case INN:
                return R.drawable.inns;
            case POI:
                return R.drawable.poi;
            case SHOP:
                return R.drawable.shops;
            default:
                return 0;
        }
    }

    public int getColorId() {
        switch (category){
            case CHARACTER:
                return R.color.category_people;
            case CITY:
                return R.color.category_cities;
            case INN:
                return R.color.category_inns;
            case POI:
                return R.color.category_poi;
            case SHOP:
                return R.color.category_shops;
            default:
                return R.color.background;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public categories getCategory() {
        return category;
    }

    public void setCategory(categories category) {
        this.category = category;
    }

    public PathItem getOwner() {
        return owner;
    }

    public void setOwner(PathItem owner) {
        this.owner = owner;
    }

    /*
    Comparable implementation
     */

    public int compareTo(@NonNull PathItem other) {
        /*
        Allows to sort a PathItem list.
         */
        return getItemName().compareTo(other.getItemName());
    }

    /*
    Parcelable implementation
     */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getItemName());
        parcel.writeInt(getImageResourceId());
        parcel.writeInt(getAvatarResourceId());
        parcel.writeString(getDescription());
        parcel.writeSerializable(getCategory());
        parcel.writeParcelable(getOwner(), i);
    }

    public static final Parcelable.Creator<PathItem> CREATOR
            = new Parcelable.Creator<PathItem>() {
        public PathItem createFromParcel(Parcel in) {
            return new PathItem(in);
        }

        public PathItem[] newArray(int size) {
            return new PathItem[size];
        }
    };

    protected PathItem(Parcel in){
        setItemName(in.readString());
        setImageResourceId(in.readInt());
        setAvatarResourceId(in.readInt());
        setDescription(in.readString());
        setCategory((PathItem.categories) in.readSerializable());
        setOwner((PathItem) in.readParcelable(PathItem.class.getClassLoader()));
    }
}
