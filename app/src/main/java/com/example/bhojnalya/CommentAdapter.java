package com.example.bhojnalya;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class CommentAdapter extends FirestoreRecyclerAdapter<Comment, CommentAdapter.CommentViewHolder> {
    Context context;
    public CommentAdapter(@NonNull FirestoreRecyclerOptions<Comment> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull CommentViewHolder holder, int position, @NonNull Comment comment) {

        holder.titleTextView.setText(comment.title);
        holder.contentTextView.setText(comment.content);
        holder.timestampTextView.setText(Utility.timestampToString(comment.timestamp));

        holder.itemView.setOnClickListener((v) -> {
            Intent intent = new Intent(context, CommentDetailsActivity.class);
            intent.putExtra("title", comment.title);
            intent.putExtra("content", comment.content);
            String docId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docId", docId);
            context.startActivity(intent);
        });

    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_comment_item, parent, false);
        return new CommentViewHolder(view);
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, contentTextView, timestampTextView;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.comment_title_text_view);
            contentTextView = itemView.findViewById(R.id.comment_content_text_view);
            timestampTextView = itemView.findViewById(R.id.comment_timestamp_text_view);
        }
    }
}
