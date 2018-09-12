package com.example.khaleef.multiselectlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.RecyclerViewHolder>{
    Context context;
    LayoutInflater inflater;
    List<Item> items, selected;

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    public ItemAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.selected = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.recycle_item, parent, false);

        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
        final Item item = items.get(position);
        holder.tv.setText(item.getTitle());
        holder.tv.setTag(holder);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected.contains(item)) {
                    selected.remove(item);
                    unhighlightView(holder);
                } else {
                    selected.add(item);
                    highlightView(holder);
                }
            }
        });

        if (selected.contains(item))
            highlightView(holder);
        else
            unhighlightView(holder);
    }

    private void highlightView(RecyclerViewHolder holder) {
        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
    }

    private void unhighlightView(RecyclerViewHolder holder) {
        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addAll(List<Item> items) {
        clearAll(false);
        this.items = items;
        notifyDataSetChanged();
    }

    public void clearAll(boolean isNotify) {
        items.clear();
        selected.clear();
        if (isNotify) notifyDataSetChanged();
    }

    public void clearSelected() {
        selected.clear();
        notifyDataSetChanged();
    }

    public void selectAll() {
        selected.clear();
        selected.addAll(items);
        notifyDataSetChanged();
    }

    public List<Item> getSelected() {
        return selected;
    }
}