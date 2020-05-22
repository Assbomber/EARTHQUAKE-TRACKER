package com.example.earthquakefromstart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class detailActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C1019R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(C1019R.C1022id.toolbardetail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle((CharSequence) "Details");
        toolbar.setBackgroundColor(getResources().getColor(C1019R.C1020color.colorPrimary));
        toolbar.setTitleTextColor(getResources().getColor(C1019R.C1020color.white));
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C1019R.C1022id.map)).getMapAsync(new OnMapReadyCallback() {
            public void onMapReady(GoogleMap googleMap) {
                LatLng latLng = new LatLng(detailActivity.this.getIntent().getDoubleExtra("Latitude", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), detailActivity.this.getIntent().getDoubleExtra("Longitude", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
                googleMap.addMarker(new MarkerOptions().position(latLng).title("marker"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            }
        });
        TextView title = (TextView) findViewById(C1019R.C1022id.tit);
        StringBuilder sb = new StringBuilder();
        sb.append(getIntent().getStringExtra("forwardtitle"));
        sb.append(" ");
        sb.append(getIntent().getStringExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
        title.setText(sb.toString());
        ((TextView) findViewById(C1019R.C1022id.changeMag)).setText(getIntent().getStringExtra("magnitude"));
        ((TextView) findViewById(C1019R.C1022id.changeTime)).setText(getIntent().getStringExtra("date"));
        ((TextView) findViewById(C1019R.C1022id.changeStatus)).setText(getIntent().getStringExtra("status"));
        TextView lat = (TextView) findViewById(C1019R.C1022id.changelat);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getIntent().getDoubleExtra("Latitude", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        String str = ",";
        sb2.append(str);
        lat.setText(sb2.toString());
        TextView lon = (TextView) findViewById(C1019R.C1022id.changelon);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getIntent().getDoubleExtra("Longitude", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        sb3.append(str);
        lon.setText(sb3.toString());
        TextView dep = (TextView) findViewById(C1019R.C1022id.changedepth);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("");
        sb4.append(getIntent().getDoubleExtra("depth", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        dep.setText(sb4.toString());
        ((TextView) findViewById(C1019R.C1022id.changeFelt)).setText(getIntent().getStringExtra("alert"));
        ((Button) findViewById(C1019R.C1022id.moredetails)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(detailActivity.this.getIntent().getStringExtra(PlusShare.KEY_CALL_TO_ACTION_URL)));
                detailActivity.this.startActivity(intent);
            }
        });
    }
}
