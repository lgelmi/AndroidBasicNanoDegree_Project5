package com.example.android.pathadvisor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class PathFragment extends Fragment {

    private PathAdapter adapter;

    private ArrayList<PathItem> itemList;

    public PathFragment() {
        // Required empty public constructor
    }

    public ArrayList<PathItem> getItemList() {
        if (itemList == null)
            // Fallback procedure
            return new ArrayList<>();
        else
            return itemList;
    }

    public void setItemList(ArrayList<PathItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);
        adapter = new PathAdapter(getActivity(), getItemList());
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }
}
