package com.example.protectplus.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protectplus.R;
import com.example.protectplus.model.MenuItem;

import java.util.List;

public class HorizontalMenuAdapter extends RecyclerView.Adapter<HorizontalMenuAdapter.ViewHolder> { // Extend RecyclerView.Adapter<ViewHolder>

    private List<MenuItem> itemList; // List of your items
    private OnMenuItemClickListener clickListener;

    public HorizontalMenuAdapter(List<MenuItem> itemList) {
        this.itemList = itemList;
    }
    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        this.clickListener = listener;
    }

    // Create and return a ViewHolder for each item
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(view);
    }

    // Bind the data to the ViewHolder at the given position
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuItem item = itemList.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getIcon());  // Use appropriate drawable

        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onMenuItemClick(item);
            }
        });
    }

    // Return the size of the data list
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // ViewHolder class to hold references to the views in the layout
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            icon = itemView.findViewById(R.id.item_icon);
        }
    }
    public interface OnMenuItemClickListener {
        void onMenuItemClick(com.example.protectplus.model.MenuItem menuItem);
    }
}

