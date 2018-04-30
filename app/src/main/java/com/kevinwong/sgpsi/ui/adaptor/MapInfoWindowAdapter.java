package com.kevinwong.sgpsi.ui.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.gson.Gson;
import com.kevinwong.sgpsi.R;
import com.kevinwong.sgpsi.model.RegionMetadatum;

/**
 * Created by JiawenHuang on 30/4/18.
 */

public class MapInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    Context mContext;

    public MapInfoWindowAdapter(Context context) {
        mContext = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.custom_info_window_layout, null);
        String string = marker.getSnippet();
        Gson gson = new Gson();
        RegionMetadatum regionMetadatum = gson.fromJson(string, RegionMetadatum.class);

       TextView tv_desc =  view.findViewById(R.id.tv_info_window_description);
        TextView tv_title =  view.findViewById(R.id.tv_info_window_title);

        tv_title.setText(regionMetadatum.getName().toUpperCase());
        tv_desc.setText(regionMetadatum.toString());

        return view;
    }
}
