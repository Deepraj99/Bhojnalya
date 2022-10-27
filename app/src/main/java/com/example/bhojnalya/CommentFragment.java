package com.example.bhojnalya;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.Query;

public class CommentFragment extends Fragment {

    FloatingActionButton addCommentBtn;
    RecyclerView recyclerView;
    ImageView menuBtn;
    CommentAdapter commentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View commentFragment = inflater.inflate(R.layout.fragment_comment, container, false);
        addCommentBtn = commentFragment.findViewById(R.id.add_comment_btn);
        addCommentBtn.setOnClickListener((v) -> startActivity(new Intent(getActivity(), CommentDetailsActivity.class)));

        recyclerView = commentFragment.findViewById(R.id.recycler_view);
        menuBtn = commentFragment.findViewById(R.id.menu_btn);

        menuBtn.setOnClickListener((v) -> showMenu());
        setupRecyclerView();

        return commentFragment;
    }

    void showMenu() {}
    void setupRecyclerView() {

        Query query = Utility.getCollectionReferenceForComments().orderBy("timestamp", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Comment> options = new FirestoreRecyclerOptions.Builder<Comment>()
                .setQuery(query, Comment.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        commentAdapter = new CommentAdapter(options, getContext());
        recyclerView.setAdapter(commentAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        commentAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        commentAdapter.stopListening();
    }

    @Override
    public void onResume() {
        super.onResume();
        commentAdapter.notifyDataSetChanged();
    }
}