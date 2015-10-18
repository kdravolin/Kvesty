package org.unicorns.kvesty.fragment;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.unicorns.kvesty.R;
import org.unicorns.kvesty.adapter.RoomAdapter;
import org.unicorns.kvesty.entity.Room;
import org.unicorns.kvesty.factory.ParseDataFactory;
import org.unicorns.kvesty.loader.RoomLoader;
import org.unicorns.kvesty.response.Response;

import java.util.List;

public class RoomListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Response>{
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RoomAdapter mRoomAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room_list, container, false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRoomAdapter = new RoomAdapter();
        mRecyclerView.setAdapter(mRoomAdapter);

        getLoaderManager().initLoader(R.id.room_loader, Bundle.EMPTY, this);

        return view;
    }

    @Override
    public Loader<Response> onCreateLoader(int id, Bundle args) {
        if (id == R.id.room_loader) {
            return new RoomLoader(getActivity(), new ParseDataFactory());
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Response> loader, Response data) {
        int id = loader.getId();
        if (id == R.id.room_loader) {
            List<Room> rooms = data.getTypedAnswer();
            mRoomAdapter.setRooms(rooms);
        }
        getLoaderManager().destroyLoader(id);
    }

    @Override
    public void onLoaderReset(Loader<Response> loader) {

    }
}
