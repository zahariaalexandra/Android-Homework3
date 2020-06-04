package com.example.homework3.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework3.Entities.User;
import com.example.homework3.R;
import com.example.homework3.Utils.UserAdapter;
import com.example.homework3.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UsersFragment extends Fragment {

    private RecyclerView usersRecyclerView;
    private List<User> users;
    private RecyclerView.Adapter<UserAdapter.ViewHolder> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);

        usersRecyclerView = view.findViewById(R.id.usersRecyclerView);
        populateUsersRecyclerView();

        return view;
    }

    private void populateUsersRecyclerView() {
            String jsonString = Utils.getJsonFromAssets(getContext(), "users.json");
            Gson gson = new Gson();
            Type listUserType = new TypeToken<List<User>>() { }.getType();
            users = gson.fromJson(jsonString, listUserType);

            usersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new UserAdapter(users);
            usersRecyclerView.setAdapter(adapter);
    }
}
