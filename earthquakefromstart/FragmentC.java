package com.example.earthquakefromstart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FragmentC extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C1019R.layout.fragmentc, container, false);
        ((SupportMapFragment) getChildFragmentManager().findFragmentById(C1019R.C1022id.map)).getMapAsync(new OnMapReadyCallback() {
            public void onMapReady(GoogleMap googleMap) {
                googleMap.clear();
                for (int i = 0; i < FragmentB.arrayList.size(); i++) {
                    Item item = (Item) FragmentB.arrayList.get(i);
                    LatLng latLng = new LatLng(item.getLatitude(), item.getLongitude());
                    MarkerOptions title = new MarkerOptions().position(latLng).title(item.getLocation2());
                    StringBuilder sb = new StringBuilder();
                    sb.append("Magnitude: ");
                    sb.append(item.getMagnitude());
                    googleMap.addMarker(title.snippet(sb.toString()));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                }
            }
        });
        return v;
    }
}
