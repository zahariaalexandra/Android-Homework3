package com.example.homework3.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework3.Entities.ToDo;
import com.example.homework3.Entities.User;
import com.example.homework3.R;
import com.example.homework3.Utils.OnItemClick;
import com.example.homework3.Utils.RecyclerTouchListener;
import com.example.homework3.Utils.ToDoAdapter;
import com.example.homework3.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToDosFragment extends Fragment {

    private User user;
    private RecyclerView toDosRecyclerView;
    private List<ToDo> toDos;
    private ToDoAdapter adapter;
    private RecyclerView.LayoutManager manager;

    public ToDosFragment(User user)
    {
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo, container, false);
        toDosRecyclerView = view.findViewById(R.id.todoRecyclerView);
        populateToDosRecyclerView(user);

        toDosRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), toDosRecyclerView, new OnItemClick() {
            @Override
            public void onItemClick(View view, int position) {
                ToDo toDo = toDos.get(position);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentFrame, new NotificationFragment(toDo));
                transaction.commit();
            }
        }));

        return view;
    }

    private void populateToDosRecyclerView(User user) {
        String fileName = "todos" + user.getId() + ".json";
        String jsonString = Utils.getJsonFromAssets(getContext(), fileName);
        Gson gson = new Gson();
        Type listToDoType = new TypeToken<List<ToDo>>() {}.getType();
        toDos = gson.fromJson(jsonString, listToDoType);

        manager = new LinearLayoutManager(getActivity());
        toDosRecyclerView.setLayoutManager(manager);
        adapter = new ToDoAdapter(toDos);
        toDosRecyclerView.setAdapter(adapter);
    }
}
