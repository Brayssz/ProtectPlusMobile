package com.example.protectplus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protectplus.R;
import com.example.protectplus.model.LocationModel;

import java.util.List;
public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

    private List<LocationModel> locationList;
    private Context context;

    public LocationAdapter(Context context, List<LocationModel> locationList) {
        this.context = context;
        this.locationList = locationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.evacuation_location_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LocationModel location = locationList.get(position);

        holder.tvBarangayName.setText(location.getBarangayName());
        holder.tvLocationName.setText(location.getLocationName());
        holder.tvLocationAddress.setText(location.getLocationAddress());
        holder.ivLocationImage.setImageResource(location.getImageResource());

        holder.btnDirection.setOnClickListener(v ->
                Toast.makeText(context, "Opening directions for " + location.getLocationName(), Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBarangayName, tvLocationName, tvLocationAddress;
        ImageView ivLocationImage;
        Button btnDirection;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBarangayName = itemView.findViewById(R.id.tvBarangayName);
            tvLocationName = itemView.findViewById(R.id.tvLocationName);
            tvLocationAddress = itemView.findViewById(R.id.tvLocationAddress);
            ivLocationImage = itemView.findViewById(R.id.ivLocationImage);
            btnDirection = itemView.findViewById(R.id.btnDirection);
        }
    }
}

