package com.example.bhojnalya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;


public class CommentDetailsActivity extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    ImageView saveNoteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_details);

        titleEditText = findViewById(R.id.comment_title_text);
        contentEditText = findViewById(R.id.comment_content_text);
        saveNoteBtn = findViewById(R.id.save_comment);

        saveNoteBtn.setOnClickListener( (v) -> saveComment());
    }

    void saveComment() {
        String commentTitle = titleEditText.getText().toString();
        String commentContent = contentEditText.getText().toString();

        if(commentTitle.isEmpty()) {
            titleEditText.setError("Title is required.");
            return;
        }
        if(commentContent.isEmpty()) {
            contentEditText.setError("Comment is required.");
            return;
        }

        Comment comment = new Comment();
        comment.setTitle(commentTitle);
        comment.setContent(commentContent);
        comment.setTimestamp(Timestamp.now());

        saveCommentToFirebase(comment);

    }

    void saveCommentToFirebase(Comment comment) {

        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForComments().document();

        documentReference.set(comment).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Utility.showToast(CommentDetailsActivity.this, "Comment added successfully!");
                    finish();
                }
                else {
                    Utility.showToast(CommentDetailsActivity.this, "Failed while adding comment.");
                }
            }
        });
    }
}