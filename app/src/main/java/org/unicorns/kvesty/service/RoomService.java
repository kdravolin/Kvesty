package org.unicorns.kvesty.service;

import org.unicorns.kvesty.Authorization;
import org.unicorns.kvesty.entity.Room;
import org.unicorns.kvesty.entity.RoomResult;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

public interface RoomService {
    @Headers({Authorization.ApiKey, Authorization.AppId})
    @GET("/1/classes/Room/{objectId}")
    Call<Room> getRoom(@Path("objectId")String objectId);

    @Headers({Authorization.ApiKey, Authorization.AppId})
    @GET("/1/classes/Room")
    Call<RoomResult> listRooms();
}
