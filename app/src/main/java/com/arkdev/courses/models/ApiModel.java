package com.arkdev.courses.models;

import com.arkdev.courses.models.Child;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiModel {
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("tags")
    @Expose
    public List<Object> tags = null;
    @SerializedName("date_modified")
    @Expose
    public String dateModified;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("children")
    @Expose
    public List<Child> children = null;

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
