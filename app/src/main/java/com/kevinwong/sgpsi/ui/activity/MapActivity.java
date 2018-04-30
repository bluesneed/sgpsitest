package com.kevinwong.sgpsi.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.kevinwong.sgpsi.R;
import com.kevinwong.sgpsi.data.network.PSIService;
import com.kevinwong.sgpsi.data.network.retrofit.RetrofitClient;
import com.kevinwong.sgpsi.model.PSIResponse;
import com.kevinwong.sgpsi.model.RegionMetadatum;
import com.kevinwong.sgpsi.ui.adaptor.MapInfoWindowAdapter;
import com.kevinwong.sgpsi.ui.iview.MapActivityView;
import com.kevinwong.sgpsi.ui.presenter.MapActivityPresenter;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback, MapActivityView {

    private GoogleMap mMap;
    private final static double SG_LAT = 1.290270;
    private final static double SG_LNG = 103.851959;

    private MapActivityPresenter mapActivityPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PSIService psiService = RetrofitClient.create(PSIService.class);
        mapActivityPresenter = new MapActivityPresenter(psiService, this, this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        configureMap();
        mapActivityPresenter.getPSIData();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void configureMap() {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(SG_LAT, SG_LNG), 10f));
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.setInfoWindowAdapter(new MapInfoWindowAdapter(this));
    }


    @Override
    public void onPSIInfoLoadSuccess(PSIResponse psiResponse) {
        for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
            LatLng latLng = new LatLng(regionMetadatum.getLabelLocation().getLatitude(), regionMetadatum.getLabelLocation().getLongitude());
            MarkerOptions markerOptions = new MarkerOptions().position(latLng)
                    .anchor(0.5f, 0.5f);
            Gson gson = new Gson();
            String regionMetadatumString = gson.toJson(regionMetadatum);
            markerOptions.snippet(regionMetadatumString);
            mMap.addMarker(markerOptions);
        }
    }

    @Override
    public void onPSIInfoLoadError(String resaon) {
        Toast.makeText(this, resaon, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        mapActivityPresenter.finish();
        super.onStop();
    }
}
