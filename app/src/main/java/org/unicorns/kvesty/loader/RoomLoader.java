package org.unicorns.kvesty.loader;

import android.content.Context;

import org.unicorns.kvesty.response.RequestResult;
import org.unicorns.kvesty.response.Response;
import org.unicorns.kvesty.response.RoomResponse;
import org.unicorns.kvesty.entity.RoomResult;
import org.unicorns.kvesty.factory.DataFactory;
import org.unicorns.kvesty.service.RoomService;

import java.io.IOException;

import retrofit.Call;

public class RoomLoader extends BaseLoader{

    public RoomLoader(Context context, DataFactory dataFactory) {
        super(context, dataFactory);
    }

    @Override
    protected Response apiCall() throws IOException {
        RoomService service = mDataFactory.getRoomService();
        Call<RoomResult> call = service.listRooms();
        RoomResult result = call.execute().body();
        return new RoomResponse()
                .setRequestResult(RequestResult.SUCCESS)
                .setAnswer(result.rooms);
    }
}
