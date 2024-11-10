package com.suri.java.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<Property> propertyList = new ArrayList<>();
        List<Property> propertyList1 = new ArrayList<>();
        Property p1 = new Property("P1", Boolean.FALSE, Boolean.FALSE,"F");
        Property p2 = new Property("P2", Boolean.TRUE, Boolean.FALSE, "B");
        Property p3 = new Property("P3", Boolean.FALSE, Boolean.FALSE, "M");
        Property p4 = new Property("P4", Boolean.TRUE, Boolean.TRUE,"P");
        Property p5 = new Property("P5", null, Boolean.FALSE, "K");
        Property p6 = new Property("P6", Boolean.TRUE, Boolean.FALSE, "T");
        Property p7 = new Property("P7", Boolean.FALSE, null, "A");
        Property p8 = new Property("P8", Boolean.TRUE, Boolean.FALSE, "C");
        Property p9 = new Property("P9", Boolean.FALSE, Boolean.FALSE, null);
        Property p10 = new Property("P10", Boolean.TRUE, Boolean.TRUE, "Z");
        propertyList.add(p1);
        propertyList.add(p2);
        propertyList.add(p3);
        propertyList.add(p4);
        propertyList.add(p5);
        propertyList.add(p6);
        propertyList.add(p7);
        propertyList.add(p8);
        propertyList.add(p9);
        propertyList.add(p10);


        Collections.sort(propertyList1, new Comparator<Property>() {

                   /* @Override
                    public int compare(Property o1, Property o2) {
                        if (o1 == null && o2 == null) return 0;
                        if (o1 == null) return -1;
                        if (o2 == null) return 1;
                        return Comparator
                                .comparing(Property::getSelected,
                                        Comparator.nullsFirst(Comparator.naturalOrder()))
                                .thenComparing(Property::getDisabled,
                                        Comparator.nullsFirst(Comparator.naturalOrder())).reversed()
                                .compare(o1, o2);
                    }*/

                @Override
                public int compare(Property p1, Property p2) {
                    return Boolean.compare(p1.getSelected(), p2.getSelected()) * -1;
                }
            }.thenComparing(new Comparator<Property>() {
                @Override
                public int compare(Property p1, Property p2) {

                    return Boolean.compare(p1.getDisabled(), p2.getDisabled());
                }
            }).thenComparing(new Comparator<Property>() {
                @Override
                public int compare(Property p1, Property p2) {
                    return p1.getProductName().compareToIgnoreCase(p2.getProductName());
                }
            }));

        //System.out.println(propertyList);

    }
}

class Property {

    private String name;
    private Boolean disabled;
    private Boolean selected;
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    public Property(String name, Boolean disabled, Boolean selected, String productName) {
        this.name = name;
        this.disabled = disabled;
        this.selected = selected;
        this.productName = productName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }


    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", disabled=" + disabled +
                ", selected=" + selected +
                ", productName='" + productName + '\'' +
                '}';
    }
}
