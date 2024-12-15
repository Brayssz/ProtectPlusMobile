package com.example.protectplus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.protectplus.R;
import com.example.protectplus.model.User;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;
    private OnUserActionListener actionListener;

    public UserAdapter(List<User> userList, OnUserActionListener actionListener) {
        this.userList = userList;
        this.actionListener = actionListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_user_row, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.userId.setText("ID: " + user.getId());
        holder.userName.setText("Name: " + user.getName());
        holder.userPosition.setText("Position: " + user.getPosition());

        holder.editButton.setOnClickListener(v -> actionListener.onEdit(user));
        holder.deleteButton.setOnClickListener(v -> actionListener.onDelete(user));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userId, userName, userPosition;
        Button editButton, deleteButton;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.user_id);
            userName = itemView.findViewById(R.id.user_name);
            userPosition = itemView.findViewById(R.id.user_position);
            editButton = itemView.findViewById(R.id.edit_button);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }

    public interface OnUserActionListener {
        void onEdit(User user);
        void onDelete(User user);
    }
}
