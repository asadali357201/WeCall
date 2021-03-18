package com.example.wecall;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wecall.Activities.ChatActivity;
import com.example.wecall.databinding.ConversationViewBinding;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    Context context;
    ArrayList<User> users;
    public UsersAdapter(Context context,ArrayList<User> users){
        this.context=context;
        this.users=users;

    }
    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.conversation_view,parent,false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        User user=users.get(position);
        holder.binding.username.setText(user.getName());
        Glide.with(context).load(user.userImage)
                .placeholder(R.drawable.avatar)
                .into(holder.binding.profilePic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, ChatActivity.class);
                i.putExtra("name",user.getName());
                i.putExtra("uid",user.uid);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder{
        ConversationViewBinding binding;
        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ConversationViewBinding.bind(itemView);
        }
    }
}
