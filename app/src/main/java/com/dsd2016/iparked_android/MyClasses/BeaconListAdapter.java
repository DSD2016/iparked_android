package com.dsd2016.iparked_android.MyClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dsd2016.iparked_android.R;

import java.util.ArrayList;



public class BeaconListAdapter extends BaseAdapter{

    protected ArrayList<Beacon> beaconList;
    private LayoutInflater mInflator;


    public BeaconListAdapter(LayoutInflater mInflator) {
     super();
     this.mInflator = mInflator;
        beaconList = new ArrayList<>();
    }

    public void addAll(ArrayList<Beacon> beaconList) {
        for (Beacon beacon:beaconList) {
            this.beaconList.add(beacon);
        }
    }
    public void clear() {
        beaconList.clear();
    }
    @Override
    public int getCount() {
        return beaconList.size();
    }

    @Override
    public Object getItem(int i) {
        return beaconList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     *Class that holds beacon GUI
     */
    static class ViewHolder {
        TextView beaconName;
        TextView beaconUuid;
        TextView beaconNumbers;
        TextView beaconDistance;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        // General ListView optimization code.
        if (view == null) {
            view = mInflator.inflate(R.layout.beacon_list_view, viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.beaconName = (TextView) view.findViewById(R.id.beacon_name);
            viewHolder.beaconUuid = (TextView) view.findViewById(R.id.beacon_uuid);
            viewHolder.beaconNumbers = (TextView) view.findViewById(R.id.beacon_numbers);
            viewHolder.beaconDistance = (TextView) view.findViewById(R.id.beacon_distance);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Beacon beacon = beaconList.get(i);
        final String deviceName = beacon.getName();
        if (deviceName != null && deviceName.length() > 0) {
            viewHolder.beaconName.setText("Name: "+deviceName);
        }else {
            viewHolder.beaconName.setText("Name: unknown");
        }
        viewHolder.beaconUuid.setText("UUID:"+beacon.getUuid());
        viewHolder.beaconNumbers.setText("Major: " + beacon.getMajor() + "  Minor: " + beacon.getMinor());
        viewHolder.beaconDistance.setText("Distance: " + beacon.getDistance());
        return view;
    }

}
