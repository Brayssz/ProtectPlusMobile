package com.example.protectplus.model;

public class LocationModel {
    private String barangayName;
    private String locationName;
    private String locationAddress;
    private int imageResource;

    public LocationModel(String barangayName, String locationName, String locationAddress, int imageResource) {
        this.barangayName = barangayName;
        this.locationName = locationName;
        this.locationAddress = locationAddress;
        this.imageResource = imageResource;
    }

    public String getBarangayName() { return barangayName; }
    public String getLocationName() { return locationName; }
    public String getLocationAddress() { return locationAddress; }
    public int getImageResource() { return imageResource; }
}
