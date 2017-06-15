package com.development.tylerwindham.liscensescanner;

import android.app.ExpandableListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class VehiclePageActivity extends ExpandableListActivity {

    private ExpandableListAdapter mAdapterView;
    android.widget.ExpandableListView expandableListView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_page);

        List<Map<String, String>> groupListItem = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> childListItem = new ArrayList<List<Map<String, String>>>();

	/* ******************** Group item 1 ********************* */
        Map<String, String> group1 = new HashMap<String, String>();
        groupListItem.add(group1);
        group1.put("parentItem", "Expandable ListView");

        List<Map<String, String>> children1 = new ArrayList<Map<String, String>>();
        Map<String, String> childrenitem1 = new HashMap<String, String>();
        children1.add(childrenitem1);
        childrenitem1.put("childItem", "ListView Example");

        Map<String, String> childrenitem2 = new HashMap<String, String>();
        children1.add(childrenitem2);
        childrenitem2.put("childItem", "ListView Tutorial");

        Map<String, String> childrenitem3 = new HashMap<String, String>();
        children1.add(childrenitem3);
        childrenitem3.put("childItem", "Expandable ListView");
        childListItem.add(children1);

	/* ******************** Group Item 2  ********************* */
        Map<String, String> childrenitem6 = new HashMap<String, String>();
        groupListItem.add(childrenitem6);
        childrenitem6.put("parentItem", "Android Expandable ListView");
        List<Map<String, String>> children2 = new ArrayList<Map<String, String>>();

        Map<String, String> childrenitem7 = new HashMap<String, String>();
        children2.add(childrenitem7);
        childrenitem7.put("childItem", "Android ListView");

        Map<String, String> childrenitem8 = new HashMap<String, String>();
        children2.add(childrenitem8);
        childrenitem8.put("childItem", "Expandable ListView");

        Map<String, String> child8 = new HashMap<String, String>();
        children2.add(child8);
        child8.put("childItem", "ListView Example");
        childListItem.add(children2);


        	/* ******************** Group Item 3  ********************* */
        Map<String, String> childrenitem9 = new HashMap<String, String>();
        groupListItem.add(childrenitem9);
        childrenitem9.put("parentItem", "Expandable ListView Tutorial");
        List<Map<String, String>> children3 = new ArrayList<Map<String, String>>();

        Map<String, String> childrenitem10 = new HashMap<String, String>();
        children3.add(childrenitem10);
        childrenitem10.put("childItem", "Android ListView");

        Map<String, String> childrenitem11 = new HashMap<String, String>();
        children3.add(childrenitem11);
        childrenitem11.put("childItem", "Expandable ListView");

        Map<String, String> childrenitem12 = new HashMap<String, String>();
        children3.add(childrenitem12);
        childrenitem12.put("childItem", "ListView Example");
        childListItem.add(children3);

        mAdapterView = new SimpleExpandableListAdapter(
                this,
                groupListItem,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"parentItem"},
                new int[]{android.R.id.text1, android.R.id.text2},
                childListItem,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"childItem"},
                new int[]{android.R.id.text1}
        );
        setListAdapter(mAdapterView);
        expandableListView = getExpandableListView();
        expandableListView.setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(android.widget.ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                switch (groupPosition) {
                    case 0:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(getBaseContext(), "ListView Example",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                Toast.makeText(getBaseContext(), "ListView Tutorial",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(getBaseContext(), "Expandable ListView",
                                        Toast.LENGTH_LONG).show();
                                break;
                        }
                        break;
                    case 1:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(getBaseContext(), "Android ListView",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                Toast.makeText(getBaseContext(), "Expandable ListView",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(getBaseContext(), "Expandable ListView",
                                        Toast.LENGTH_LONG).show();
                                break;
                        }
                        break;
                    case 2:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(getBaseContext(), "Android ListView",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                Toast.makeText(getBaseContext(), "Expandable ListView",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(getBaseContext(), "ListView Example",
                                        Toast.LENGTH_LONG).show();
                                break;
                        }
                        break;
                }
                return false;
            }
        });
    }
}
