package com.suri.upstock.model;


public class Engineer {

    private String name;
    private Role role;
    private String manager;
    private int featureStory;
    private int uatBugStory;
    private int prodBugStory;

    public Engineer(String name, Role role, String manager, int featureStory, int uatBugStory, int prodBugStory) {
        this.name = name;
        this.role = role;
        this.manager = manager;
        this.featureStory = featureStory;
        this.uatBugStory = uatBugStory;
        this.prodBugStory = prodBugStory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getFeatureStory() {
        return featureStory;
    }

    public void setFeatureStory(int featureStory) {
        this.featureStory = featureStory;
    }

    public int getUatBugStory() {
        return uatBugStory;
    }

    public void setUatBugStory(int uatBugStory) {
        this.uatBugStory = uatBugStory;
    }

    public int getProdBugStory() {
        return prodBugStory;
    }

    public void setProdBugStory(int prodBugStory) {
        this.prodBugStory = prodBugStory;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "name='" + name + '\'' +
                ", role=" + role +
                ", manager='" + manager + '\'' +
                ", featureStory=" + featureStory +
                ", uatBugStory=" + uatBugStory +
                ", prodBugStory=" + prodBugStory +
                '}';
    }
}
