package com.example.bhojnalya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;


public class CommentDetailsActivity extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    ImageView saveNoteBtn;
    TextView pageTitleTextView;
    String title, content, docId;
    TextView deleteCommentTextView;
    boolean isEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_details);

        titleEditText = findViewById(R.id.comment_title_text);
        contentEditText = findViewById(R.id.comment_content_text);
        saveNoteBtn = findViewById(R.id.save_comment);
        pageTitleTextView = findViewById(R.id.tv_heading);
        deleteCommentTextView = findViewById(R.id.tv_delete);

        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        docId = getIntent().getStringExtra("docId");

        if(docId != null  &&  !docId.isEmpty()) {
            isEditMode = true;
        }

        titleEditText.setText(title);
        contentEditText.setText(content);

        if(isEditMode) {
            pageTitleTextView.setText("Edit your comment");
            deleteCommentTextView.setVisibility(View.VISIBLE);
        }
        saveNoteBtn.setOnClickListener( (v) -> saveComment());
        deleteCommentTextView.setOnClickListener((v) -> deleteCommentFromFirebase());
    }

    void deleteCommentFromFirebase() {
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForComments().document(docId);

        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Utility.showToast(CommentDetailsActivity.this, "Comment deleted successfully!");
                    finish();
                }
                else {
                    Utility.showToast(CommentDetailsActivity.this, "Failed while deleting comment.");
                }
            }
        });
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

        if(isEditMode) {
            //update the node
            documentReference = Utility.getCollectionReferenceForComments().document(docId);
        } else {
            //create new node
            documentReference = Utility.getCollectionReferenceForComments().document();
        }

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