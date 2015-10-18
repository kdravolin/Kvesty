package org.unicorns.kvesty.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import org.unicorns.kvesty.response.RequestResult;
import org.unicorns.kvesty.response.Response;
import org.unicorns.kvesty.factory.DataFactory;

import java.io.IOException;

public abstract class BaseLoader extends AsyncTaskLoader<Response> {

    protected DataFactory mDataFactory;

    public BaseLoader(Context context, DataFactory dataFactory) {
        super(context);
        mDataFactory = dataFactory;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public Response loadInBackground() {
        try {
            Response response = apiCall();
            if (response.getRequestResult() == RequestResult.SUCCESS) {
                response.save(getContext());
                onSuccess();
            } else {
                onError();
            }
            return response;
        } catch (IOException e) {
            onError();
            return new Response().setRequestResult(RequestResult.ERROR);
        }
    }

    protected void onSuccess() {
    }

    protected void onError() {
    }

    protected abstract Response apiCall() throws IOException;
}
