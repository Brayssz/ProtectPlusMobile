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

public class ModulesMenuAdapter extends RecyclerView.Adapter<ModulesMenuAdapter.MenuViewHolder> {

    private List<MenuItem> menuItems;
    private OnMenuItemClickListener clickListener;
    // Constructor to pass the menu items list
    public ModulesMenuAdapter(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        this.clickListener = listener;
    }
    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.module_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem menuItem = menuItems.get(position);
        holder.icon.setImageResource(menuItem.getIcon());
        holder.title.setText(menuItem.getTitle());

        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onMenuItemClick(menuItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    // ViewHolder class for item layout
    static class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.item_icon);
            title = itemView.findViewById(R.id.item_title);
        }
    }
    public interface OnMenuItemClickListener {
        void onMenuItemClick(com.example.protectplus.model.MenuItem menuItem);
    }
}
