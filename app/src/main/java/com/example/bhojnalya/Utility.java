package com.example.bhojnalya;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;

public class Utility {
    static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    static CollectionReference getCollectionReferenceForComments() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("comments").document(currentUser.getUid()).collection("my_comments");
    }

    static String timestampToString(Timestamp timestamp) {

        return new SimpleDateFormat("hh:mm  MM/dd/yyyy").format(timestamp.toDate());
    }
}
