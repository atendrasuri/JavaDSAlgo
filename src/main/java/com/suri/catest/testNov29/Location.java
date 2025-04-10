package com.suri.catest.testNov29;

import java.util.Arrays;

public class Location {

    private String storeId;

    private String address;

    public Location(String storeId, String address) {
        this.storeId = storeId;
        this.address = address;
    }


    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
