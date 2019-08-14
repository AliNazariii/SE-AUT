package com.muhmdreza.foodorderingsystem.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muhmdreza.foodorderingsystem.Models.CommentItem;
import com.muhmdreza.foodorderingsystem.R;


import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {
    private Context context;
    private List<CommentItem> comments;

    CommentAdapter(Context context, List<CommentItem> comments) {
        this.context = context;
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommentHolder(LayoutInflater.from(this.context).inflate(R.layout.comment_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        final CommentItem commentItem = comments.get(position);
        holder.name.setText(commentItem.getFoodName());
        holder.text.setText(commentItem.getMessage());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    class CommentHolder extends RecyclerView.ViewHolder{
        TextView name, text;
        CommentHolder(View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.txt_commentRow_name);
            this.text = itemView.findViewById(R.id.txt_commentRow_text);
        }
    }
}
