package org.unicorns.kvesty.dao;

import org.unicorns.kvesty.Authorization;
import org.unicorns.kvesty.entity.QuestHolder;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

public interface QuestHolderDao {
    @Headers({Authorization.ApiKey, Authorization.AppId})
    @GET("/1/classes/QuestHolder/{objectId}")
    Call<QuestHolder> getQuestHolder(@Path("objectId")String objectId);
}
