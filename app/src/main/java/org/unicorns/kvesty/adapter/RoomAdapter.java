package org.unicorns.kvesty.adapter;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.unicorns.kvesty.databinding.RoomItemBinding;
import org.unicorns.kvesty.entity.Room;

import java.util.ArrayList;
import java.util.List;


public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomItemViewHolder> {

    private List<Room> mRooms;

    public RoomAdapter () {
        this.mRooms = new ArrayList<>();
    }

    @Override
    public RoomItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RoomItemBinding binding = RoomItemBinding.inflate(inflater, parent, false);
        return new RoomItemViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RoomItemViewHolder holder, int position) {
        holder.binding.setRoom(mRooms.get(position));
    }

    @Override
    public int getItemCount() {
        return mRooms.size();
    }

    public void setRooms(List<Room> rooms){
        mRooms.clear();
        mRooms.addAll(rooms);
        notifyDataSetChanged();
    }

    public class RoomItemViewHolder extends RecyclerView.ViewHolder {

        RoomItemBinding binding;

        public RoomItemViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String v) {
        Picasso.with(imageView.getContext()).load(v).into(imageView);
    }
}