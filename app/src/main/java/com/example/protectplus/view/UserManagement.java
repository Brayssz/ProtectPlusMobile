package com.example.protectplus.view;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.protectplus.R;
import com.example.protectplus.adapter.UserAdapter;
import com.example.protectplus.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserManagement extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);
        recyclerView = findViewById(R.id.recyclerView); // RecyclerView ID
        userList = new ArrayList<>();

        // Sample data
        userList.add(new User(1, "John Doe", "User"));
        userList.add(new User(2, "Jane Smith", "Admin"));
        userList.add(new User(3, "Michael Johnson", "Admin"));

        adapter = new UserAdapter(userList, new UserAdapter.OnUserActionListener() {
            @Override
            public void onEdit(User user) {
                Toast.makeText(UserManagement.this, "Edit: " + user.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDelete(User user) {
                userList.remove(user);
                adapter.notifyDataSetChanged();
                Toast.makeText(UserManagement.this, "Deleted: " + user.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}