package org.unicorns.kvesty.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import org.unicorns.kvesty.databinding.QuestHolderItemBinding;
import org.unicorns.kvesty.entity.QuestHolder;


public class QuestHolderAdapter extends RecyclerView.Adapter<QuestHolderAdapter.QuestHolderItemViewHolder> {

    @Override
    public QuestHolderItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        QuestHolderItemBinding binding = QuestHolderItemBinding.inflate(inflater, parent, false);
        return new QuestHolderItemViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(QuestHolderItemViewHolder holder, int position) {
        QuestHolder questHolder = new QuestHolder();
        questHolder.name = "name_" + position;
        holder.binding.setQuestHolder(questHolder);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class QuestHolderItemViewHolder extends RecyclerView.ViewHolder {

        QuestHolderItemBinding binding;

        public QuestHolderItemViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}