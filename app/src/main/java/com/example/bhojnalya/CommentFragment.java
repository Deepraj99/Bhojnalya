package com.example.bhojnalya;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CommentFragment extends Fragment {

    FloatingActionButton addCommentBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View commentFragment = inflater.inflate(R.layout.fragment_comment, container, false);
        addCommentBtn = commentFragment.findViewById(R.id.add_comment_btn);
        addCommentBtn.setOnClickListener((v) -> startActivity(new Intent(getActivity(), CommentDetailsActivity.class)));
        return commentFragment;
    }
}