package com.androidexample.chandigarhexplore;

/**
 * Created by MANI on 1/12/2017.
 */
public class Place {

    private int cLocationId;
    private int cAddressOneId;
    private int cAddressTwoId;
    private int cPlaceImageId;
    private double cLatitudeId;
    private double cLongitudeId;

    public Place(int locationId, int addressOneId, int addressTwoId, int placeImageId, double latitudeId, double longitudeId) {
        cAddressOneId = addressOneId;
        cAddressTwoId = addressTwoId;
        cPlaceImageId = placeImageId;
        cLocationId = locationId;
        cLatitudeId = latitudeId;
        cLongitudeId = longitudeId;
    }

    public int getLocationId() {
        return cLocationId;
    }

    public int getAddressOneId() {
        return cAddressOneId;
    }

    public int getAddressTwoId() {
        return cAddressTwoId;
    }

    public int getPlaceImageId() {
        return cPlaceImageId;
    }

    public double getLatitudeId() {
        return cLatitudeId;
    }

    public double getLongitudeId() {
        return cLongitudeId;
    }


}
