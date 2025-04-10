package com.suri.catest.testNov29;





public class SubTask {

    private String subTaskId;
    private String stopType;

    private Location location;


    public SubTask(String subTaskId, String store, Location location) {
        this.subTaskId = subTaskId;
        this.stopType = store;
        this.location = location;
    }

    public String getSubTaskId() {
        return subTaskId;
    }

    public void setSubTaskId(String subTaskId) {
        this.subTaskId = subTaskId;
    }

    public String getStopType() {
        return stopType;
    }

    public void setStopType(String store) {
        this.stopType = store;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
