package com.example.android.pathadvisor;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class CategoryPageAdapter extends FragmentPagerAdapter {
    private Context context;


    private ArrayList<PathItem> itemList;

    CategoryPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        // Initialize by name those that must be linked between them.
        // Ugly, but without a database of some sort... (even a global variable/singleton might
        // suffice but I prefer to keep it this way to experiment with intents).
        PathItem abstalar = new PathItem(
                context.getString(R.string.abstalar_name), R.drawable.abstalarzantus,
                PathItem.categories.CHARACTER);
        PathItem aldern = new PathItem(
                context.getString(R.string.aldern_name), R.drawable.aldernfoxglove,
                PathItem.categories.CHARACTER);
        PathItem ameiko = new PathItem(
                context.getString(R.string.ameiko_name), R.drawable.ameikokaijitsu,
                PathItem.categories.CHARACTER);
        PathItem kendra = new PathItem(
                context.getString(R.string.kendra_name), R.drawable.kendradeverin,
                PathItem.categories.CHARACTER);
        PathItem magnimar = new PathItem(context.getString(R.string.magnimar_name),
                R.drawable.magnimar, PathItem.categories.CITY);
        PathItem sandpoint = new PathItem(context.getString(R.string.sandpoint_name),
                R.drawable.sandpoint, PathItem.categories.CITY);
        PathItem deer = new PathItem(context.getString(R.string.deer_name),
                0, PathItem.categories.INN);
        PathItem rusty = new PathItem(context.getString(R.string.rusty_name),
                R.drawable.rusty_dragon, PathItem.categories.INN);
        PathItem cathedral = new PathItem(context.getString(R.string.cathedral_name),
                R.drawable.cathedral, PathItem.categories.POI);
        PathItem oldLight = new PathItem(context.getString(R.string.old_light_name),
                R.drawable.oldlight, PathItem.categories.POI);
        PathItem savah = new PathItem(context.getString(R.string.savah_nama),
                R.drawable.armory, PathItem.categories.SHOP);
        PathItem vinder = new PathItem(context.getString(R.string.vinder_name),
                R.drawable.general_store, PathItem.categories.SHOP);
        abstalar.setAvatarResourceId(R.drawable.abstalarzantushead);
        abstalar.setDescription(context.getString(R.string.abstalar_desc));
        aldern.setAvatarResourceId(R.drawable.aldernfoxglovehead);
        aldern.setDescription(context.getString(R.string.aldern_desc));
        ameiko.setAvatarResourceId(R.drawable.ameikokaijitsuhead);
        ameiko.setDescription(context.getString(R.string.ameiko_desc));
        kendra.setAvatarResourceId(R.drawable.kendradeverinhead);
        kendra.setDescription(context.getString(R.string.kendra_desc));
        magnimar.setDescription(context.getString(R.string.magnimar_desc));
        sandpoint.setDescription(context.getString(R.string.sandpoint_desc));
        deer.setDescription(context.getString(R.string.deer_desc));
        deer.setOwner(new PathItem(context.getString(R.string.garridan_name), PathItem.categories.CHARACTER));
        rusty.setDescription(context.getString(R.string.rusty_desc));
        rusty.setOwner(ameiko);
        cathedral.setDescription(context.getString(R.string.cathedral_desc));
        cathedral.setOwner(abstalar);
        oldLight.setDescription(context.getString(R.string.old_light_desc));
        savah.setOwner(new PathItem(context.getString(R.string.savah_real_name), PathItem.categories.CHARACTER));
        savah.setDescription(context.getString(R.string.savah_desc));
        vinder.setOwner(new PathItem(context.getString(R.string.ven_name), PathItem.categories.CHARACTER));
        vinder.setDescription(context.getString(R.string.vinder_desc));
        itemList = new ArrayList<>();
        itemList.add(abstalar);
        itemList.add(aldern);
        itemList.add(ameiko);
        itemList.add(kendra);
        itemList.add(magnimar);
        itemList.add(sandpoint);
        itemList.add(deer);
        itemList.add(rusty);
        itemList.add(cathedral);
        itemList.add(oldLight);
        itemList.add(savah);
        itemList.add(vinder);
        Collections.sort(itemList);
    }

    @Override
    public Fragment getItem(int i) {
        PathFragment pathFragment = new PathFragment();
        ArrayList<PathItem> filteredList;

        switch (i) {
            case 0:
                pathFragment.setItemList(itemList);
                break;
            case 1:
                filteredList = new ArrayList<>();
                for (PathItem item : itemList)
                    if (item.getCategory() == PathItem.categories.CITY)
                        filteredList.add(item);
                pathFragment.setItemList(filteredList);
                break;
            case 2:
                filteredList = new ArrayList<>();
                for (PathItem item : itemList)
                    if (item.getCategory() == PathItem.categories.INN)
                        filteredList.add(item);
                pathFragment.setItemList(filteredList);
                break;
            case 3:
                filteredList = new ArrayList<>();
                for (PathItem item : itemList)
                    if (item.getCategory() == PathItem.categories.CHARACTER)
                        filteredList.add(item);
                pathFragment.setItemList(filteredList);
                break;
            case 4:
                filteredList = new ArrayList<>();
                for (PathItem item : itemList)
                    if (item.getCategory() == PathItem.categories.POI)
                        filteredList.add(item);
                pathFragment.setItemList(filteredList);
                break;
            case 5:
                filteredList = new ArrayList<>();
                for (PathItem item : itemList)
                    if (item.getCategory() == PathItem.categories.SHOP)
                        filteredList.add(item);
                pathFragment.setItemList(filteredList);
                break;
            default:
                return null;
        }
        return pathFragment;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.category_none);
            case 1:
                return context.getString(R.string.category_cities);
            case 2:
                return context.getString(R.string.category_inns);
            case 3:
                return context.getString(R.string.category_people);
            case 4:
                return context.getString(R.string.category_poi);
            case 5:
                return context.getString(R.string.category_shops);
            default:
                return context.getString(R.string.default_head) + (position + 1);
        }
    }
}
