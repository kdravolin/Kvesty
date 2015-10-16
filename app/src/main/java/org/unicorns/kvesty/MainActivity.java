package org.unicorns.kvesty;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.unicorns.kvesty.adapter.QuestHolderAdapter;
import org.unicorns.kvesty.dao.QuestHolderDao;
import org.unicorns.kvesty.entity.QuestHolder;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private QuestHolderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new QuestHolderAdapter();
        mRecyclerView.setAdapter(mAdapter);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.parse.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//
//        QuestHolderDao questHolderDao = retrofit.create(QuestHolderDao.class);
//        Call<QuestHolder> questHolderCall = questHolderDao.getQuestHolder("A4kFIy2xkO");
//        questHolderCall.enqueue(cb);
    }

    Callback<QuestHolder> cb = new Callback<QuestHolder>() {
        @Override
        public void onResponse(Response<QuestHolder> response, Retrofit retrofit) {
            Log.e("KV", "OK");
            QuestHolder questHolder = response.body();
            String s = questHolder.name;
        }

        @Override
        public void onFailure(Throwable t) {
            Log.e("KV", "FAIL");
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
