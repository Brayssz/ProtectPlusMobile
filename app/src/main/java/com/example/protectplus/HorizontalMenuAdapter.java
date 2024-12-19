package com.example.protectplus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protectplus.model.MenuItem;

import java.util.List;

public class HorizontalMenuAdapter extends RecyclerView.Adapter<HorizontalMenuAdapter.ViewHolder> { // Extend RecyclerView.Adapter<ViewHolder>

    private List<MenuItem> itemList; // List of your items

    private Context context;

    public HorizontalMenuAdapter(List<MenuItem> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    // Create and return a ViewHolder for each item
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuItem item = itemList.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getIcon());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open activity based on the title

                 switch (item.getTitle()) {
                    case "Modules":
                        context.startActivity(new Intent(context, Modules.class));
                        break;
                    case "Directory":
                        context.startActivity(new Intent(context, Directory.class));
                        break;

                 }

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

        private CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            icon = itemView.findViewById(R.id.item_icon);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
