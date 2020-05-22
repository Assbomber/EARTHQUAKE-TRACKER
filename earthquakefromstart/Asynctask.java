package com.example.earthquakefromstart;

import android.content.Context;
import android.os.AsyncTask;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.plus.PlusShare;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Asynctask extends AsyncTask<Void, Void, Void> {
    FragmentB fragmentB = new FragmentB(this.mcontext);
    FragmentManager fragmentManager;
    StringBuilder jsonResponse = new StringBuilder();
    Context mcontext;

    public Asynctask(Context context, FragmentManager fm) throws MalformedURLException {
        this.fragmentManager = fm;
        this.mcontext = context;
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... voids) {
        String place2;
        String place1;
        String str = " of ";
        String str2 = "features";
        String str3 = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson";
        try {
            HttpsURLConnection httpURLConnection = (HttpsURLConnection) new URL(str3).openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            for (String result = br.readLine(); result != null; result = br.readLine()) {
                this.jsonResponse.append(result);
            }
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            JSONObject response = new JSONObject(this.jsonResponse.toString());
            JSONArray features = response.getJSONArray(str2);
            int i = 0;
            while (i < features.length()) {
                JSONObject jsonObject = features.getJSONObject(i);
                JSONArray coordinates = jsonObject.getJSONObject("geometry").getJSONArray("coordinates");
                double longitude = coordinates.getDouble(0);
                double latitude = coordinates.getDouble(1);
                double depth = coordinates.getDouble(2);
                JSONObject properties = jsonObject.getJSONObject("properties");
                String mag = String.valueOf(properties.getDouble("mag"));
                String place = properties.getString("place");
                String alert = properties.getString("alert");
                String url = properties.getString(PlusShare.KEY_CALL_TO_ACTION_URL);
                String status = properties.getString("status");
                if (place.contains(str)) {
                    String[] loc = place.split(str);
                    StringBuilder sb = new StringBuilder();
                    sb.append(loc[0]);
                    sb.append(" of");
                    place1 = sb.toString();
                    place2 = loc[1];
                } else {
                    place1 = "Near of";
                    place2 = place;
                }
                JSONObject response2 = response;
                long millisec = properties.getLong("time");
                Date dateobj = new Date(millisec);
                long j = millisec;
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss zzz ");
                String date = dateFormat.format(dateobj);
                ArrayList<Item> arrayList = FragmentB.arrayList;
                SimpleDateFormat simpleDateFormat = dateFormat;
                Date date2 = dateobj;
                String str4 = place;
                JSONObject jSONObject = properties;
                Item item = new Item(mag, place1, place2, date, latitude, longitude, status, depth, url, alert);
                arrayList.add(item);
                i++;
                response = response2;
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        String[] links = {str3, "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson", "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.geojson", "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson"};
        for (int i2 = 0; i2 < links.length; i2++) {
            try {
                URL url2 = new URL(links[i2]);
                StringBuilder jsonResponse2 = new StringBuilder();
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url2.openConnection();
                BufferedReader br2 = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                for (String result2 = br2.readLine(); result2 != null; result2 = br2.readLine()) {
                    jsonResponse2.append(result2);
                }
                FragmentB.counts[i2] = new JSONObject(jsonResponse2.toString()).getJSONArray(str2).length();
                httpURLConnection2.disconnect();
            } catch (IOException e4) {
                e4.printStackTrace();
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        this.fragmentManager.beginTransaction().replace(C1019R.C1022id.framelayout, this.fragmentB).commit();
    }
}
