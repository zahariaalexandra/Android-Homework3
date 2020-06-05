package com.example.homework3.Utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework3.Entities.ToDo;
import com.example.homework3.R;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    private List<ToDo> toDos;
    private OnItemClick onClick;

    public ToDoAdapter(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public void setOnClick(OnItemClick onClick) {
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_view_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.toDo.setText(toDos.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return toDos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView toDo;

        ViewHolder(View itemView) {
            super(itemView);
            toDo = itemView.findViewById(R.id.txtTitle);
        }
    }


}

