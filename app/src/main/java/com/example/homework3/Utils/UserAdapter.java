package com.example.homework3.Utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework3.Entities.User;
import com.example.homework3.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users;
    private OnItemClick click;

    public UserAdapter(List<User> users, OnItemClick click) {
        this.users = users;
        this.click = click;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_view_holder, parent, false);
        return new ViewHolder(view, click);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(users.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Button name;
        OnItemClick click;

        ViewHolder(View itemView, OnItemClick click) {
            super(itemView);

            name = itemView.findViewById(R.id.btnUser);
            this.click = click;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            click.onUserClick(getAdapterPosition());
        }
    }

    public interface OnItemClick {
        void onUserClick(int position);
    }
}
