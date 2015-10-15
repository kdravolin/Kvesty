package org.unicorns.kvesty.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestHolder {
    @SerializedName("objectId")
    public String id;
    public String name;

    public String image;
    public String description;
}
