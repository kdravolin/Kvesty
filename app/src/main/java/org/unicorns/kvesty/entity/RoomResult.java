package org.unicorns.kvesty.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RoomResult {
    @SerializedName("results")
    public List<Room> rooms;
}
