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
                "Abstalar Zantus", R.drawable.abstalarzantus,
                PathItem.categories.CHARACTER);
        PathItem aldern = new PathItem(
                "Aldern Foxglove", R.drawable.aldernfoxglove,
                PathItem.categories.CHARACTER);
        PathItem ameiko = new PathItem(
                "Ameiko Kaijitsu", R.drawable.ameikokaijitsu,
                PathItem.categories.CHARACTER);
        PathItem kendra = new PathItem(
                "Kendra Deverin", R.drawable.kendradeverin,
                PathItem.categories.CHARACTER);
        PathItem magnimar = new PathItem("Magnimar",
                R.drawable.magnimar, PathItem.categories.CITY);
        PathItem sandpoint = new PathItem("Sandpoint",
                R.drawable.sandpoint, PathItem.categories.CITY);
        PathItem deer = new PathItem("The White Deer",
                0, PathItem.categories.INN);
        PathItem rusty = new PathItem("The Rusty Dragon",
                R.drawable.rusty_dragon, PathItem.categories.INN);
        PathItem cathedral = new PathItem("Sandpoint Cathedral",
                R.drawable.cathedral, PathItem.categories.POI);
        PathItem oldLight = new PathItem("The Old Light",
                R.drawable.oldlight, PathItem.categories.POI);
        PathItem savah = new PathItem("Savah's Armory",
                R.drawable.armory, PathItem.categories.SHOP);
        PathItem vinder = new PathItem("Vinder's General Store",
                R.drawable.general_store, PathItem.categories.SHOP);
        abstalar.setAvatarResourceId(R.drawable.abstalarzantushead);
        abstalar.setDescription("When the Sandpoint chapel burnt to the ground in 4702 AR, " +
                "killing the town's priest, Ezakien Tobyn, his position in the town was filled by" +
                " his top acolyte, Abstalar Zantus.\n Though Father Zantus is himself a cleric of" +
                " Desna, his role as high-priest requires him to be open to other faiths, and he " +
                "is more than willing and open to assist followers of other gods with spiritual " +
                "matters.");
        aldern.setAvatarResourceId(R.drawable.aldernfoxglovehead);
        aldern.setDescription("Aldern Foxglove, son of Traver and Cyralie Foxglove, was a minor " +
                "Magnimarian noble with a cursed fate.\nKnown primarily for his way with women, " +
                "Aldern was unlucky in ways financial and fell in with the wrong crowd—a band of " +
                "cultists who would lead him down the path of betrayal, madness, and murder.");
        ameiko.setAvatarResourceId(R.drawable.ameikokaijitsuhead);
        ameiko.setDescription("Ameiko Kaijitsu is best known in the Varisian town of Sandpoint as" +
                " the proprietor of the Rusty Dragon, the most popular tavern in town.\nA member " +
                "of the town's small aristocracy, she is the eldest daughter of Lonjiku Kaijitsu " +
                "and Atsuii Kaijitsu, and half-sister of both Amaya and Tsuto Kaijitsu (who " +
                "are unrelated to each other).");
        kendra.setAvatarResourceId(R.drawable.kendradeverinhead);
        kendra.setDescription("Kendra Deverin has served as Sandpoint's mayor since 4702 AR. " +
                "Lawmaker, judge, and general peacemaker, she has proven to be both an adept " +
                "diplomat and stern hand when need be, both skills honed during her youth in " +
                "Magnimar.\nWith a personal—some say sisterly—style of governing, most of " +
                "Sandpoint's citizens hold deep respect for their fiery-haired mayor.\n\n" +
                "Kendra is the niece of Lord Hobart Deverin, the head of her family in Magnimar.");
        magnimar.setDescription("The city of Magnimar (pronounced MAG-nih-mahr) stands as one " +
                "of the two major city-states of southern Varisia.\nFounded by Korvosan " +
                "dissenters in 4608 AR, the City of Monuments now stands as a rival to Korvosa in" +
                " an open war of coin and words. ");
        sandpoint.setDescription("Resting in a natural cove along the cliff-lined Lost Coast " +
                "region of Varisia, on the edge of the Varisian Gulf, Sandpoint is a medium-sized" +
                " city that exemplifies the diverse people of the country.\n\nWhile only about " +
                "thirty miles northeast of the city of Magnimar and technically under its rule, " +
                "Sandpoint benefits from its isolated position in its ability to remain fairly " +
                "independent.\n\nThe most striking feature is the ruined beacon of the city that " +
                "extends high above the cliffs of the coast, reflecting the ancient empire of " +
                "Thassilon that existed here centuries before the present town was settled.");
        deer.setDescription("he White Deer is an inn and tavern, and the northernmost building in" +
                " the town of Sandpoint.\nRebuilt after a building at the same location burned as" +
                " " +
                "part of the late unpleasantness, in 4702 AR, this business is owned and " +
                "primarily maintained by one Garridan Viskalai and his family.");
        deer.setOwner(new PathItem("Garridan Viksalay", PathItem.categories.CHARACTER));
        rusty.setDescription("The Rusty Dragon is the oldest inn in Sandpoint, and thanks to its " +
                "owner and its ever-present \"Help Wanted\" board is also one of the most popular" +
                " and adventurer-friendly.\nOwned and operated by Ameiko Kaijitsu, the inn can be" +
                " found just past the southern bridge overlooking the Turandarok River at the " +
                "corner of Market and River Streets. Known for its spicy and exotic foods, it is " +
                "a favorite at the community's annual Swallowtail Festival free lunch.");
        rusty.setOwner(ameiko);
        cathedral.setDescription("The current Sandpoint Cathedral was dedicated in the year 4707 " +
                "AR.\n\nLocated in the town of Sandpoint, this structure was built to replace a " +
                "chapel that was destroyed by a fire five years earlier in a series of events " +
                "that have become known as the late unpleasantness.\nThe new building has been " +
                "established on the same site as the old, and has been greatly improved upon " +
                "through the efforts of Sandpoint's citizens and the initiative of the town's " +
                "mayor, Kendra Deverin.");
        cathedral.setOwner(abstalar);
        oldLight.setDescription("The Old Light is the most visible landmark of the western " +
                "Varisian town of Sandpoint.\nIt is believed to have been a lighthouse during the" +
                " ancient Thassilonian empire, though much of the structure has crumbled over the" +
                " ages.");
        savah.setOwner(new PathItem("Savah", PathItem.categories.CHARACTER));
        savah.setDescription("Savah's Armory, owned and run by Savah Bevaniky, can be found on " +
                "Tower Street in Sandpoint.\n\n It sells many types of armor and weapons, " +
                "including well-made items and exotic weapons such as spiked chains, shuriken, " +
                "and a magical repeating crossbow.\n\n" +
                "The building was damaged during the Sandpoint Fire of 4702 AR, but thanks to " +
                "Bevaniky's quick work, it did not cause any irreparable damage.");
        vinder.setOwner(new PathItem("Ven Vinder", PathItem.categories.CHARACTER));
        vinder.setDescription("Owned and operated by Ven Vinder and his family, Sandpoint's " +
                "oldest and best-stocked general store has a little bit of everything: farm " +
                "equipment, weapons, tack, tools, furniture, food, and even homemade pies baked " +
                "by Ven's wife Solsta.");
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
                return "OBJECT " + (position + 1);
        }
    }
}
