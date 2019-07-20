package com.arkdev.courses.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Child {
    @SerializedName("internal_id")
    @Expose
    private String courseID;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("icon_large")
    @Expose
    private String iconLarge;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;

    // Note: Not all the info
    public Child(String courseID, String title, String icon, String iconLarge, String url, String description) {
        this.courseID = courseID;
        this.description = description;
        this.icon = icon;
        this.iconLarge = iconLarge;
        this.title = title;
        this.url = url;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        courseID = courseID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconLarge() {
        return iconLarge;
    }

    public void setIconLarge(String iconLarge) {
        this.iconLarge = iconLarge;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
