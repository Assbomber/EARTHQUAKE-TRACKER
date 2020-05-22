package com.example.earthquakefromstart;

public class Item {
    private String alert;
    private String date;
    private double depth;
    private double latitude;
    private String location1;
    private String location2;
    private double longitude;
    private String magnitude;
    private String status;
    private String url;

    public Item(String mag, String loc1, String loc2, String dat, double lat, double lon, String stat, double dep, String ur, String al) {
        this.magnitude = mag;
        this.location1 = loc1;
        this.location2 = loc2;
        this.date = dat;
        this.latitude = lat;
        this.longitude = lon;
        this.status = stat;
        this.depth = dep;
        this.url = ur;
        this.alert = al;
    }

    public String getAlert() {
        return this.alert;
    }

    public String getUrl() {
        return this.url;
    }

    public double getDepth() {
        return this.depth;
    }

    public String getStatus() {
        return this.status;
    }

    public String getDate() {
        return this.date;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getLocation1() {
        return this.location1;
    }

    public String getLocation2() {
        return this.location2;
    }

    public String getMagnitude() {
        return this.magnitude;
    }
}
