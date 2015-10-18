package org.unicorns.kvesty.factory;

import org.unicorns.kvesty.factory.DataFactory;
import org.unicorns.kvesty.service.RoomService;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ParseDataFactory implements DataFactory {

    private final RoomService mRoomService;

    public ParseDataFactory() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.parse.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mRoomService = retrofit.create(RoomService.class);
    }

    @Override
    public RoomService getRoomService() {
        return mRoomService;
    }
}
