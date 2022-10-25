package com.example.bhojnalya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText, confirmPasswordEditText;
    Button createAccountBtn;
    ProgressBar progressBar;
    TextView loginBtnTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Bundle bundle = getIntent().getExtras();
        boolean isStudent = bundle.getBoolean("is_student");

        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        confirmPasswordEditText = findViewById(R.id.confirm_password_edit_text);
        createAccountBtn = findViewById(R.id.create_account_btn);
        progressBar = findViewById(R.id.progress_bar);
        loginBtnTextView = findViewById(R.id.login_text_view_btn);

        progressBar.getIndeterminateDrawable().setColorFilter(0xFFF89C04, android.graphics.PorterDuff.Mode.MULTIPLY);

        createAccountBtn.setOnClickListener(v -> createAccount(isStudent));
        loginBtnTextView.setOnClickListener(v -> finish());
    }
    void createAccount(boolean isStudent) {

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();
        boolean isValidated = validateData(email, password, confirmPassword, isStudent);

        if(!isValidated) {
            return;
        }
        createAccountInFirebase(email, password);
    }

    void createAccountInFirebase(String email, String password) {

        changeInProgress(true);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        changeInProgress(false);
                        if(task.isSuccessful()) {
                            Utility.showToast(SignUpActivity.this, "Successfully created account, Check email to verify");
                            firebaseAuth.getCurrentUser().sendEmailVerification();
                            firebaseAuth.signOut();
                            finish();
                        } else {
                            Utility.showToast(SignUpActivity.this, task.getException().getLocalizedMessage());
                        }
                    }
                });
    }
    void changeInProgress(boolean inProgress) {
        if(inProgress) {
            createAccountBtn.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
            createAccountBtn.setVisibility(View.VISIBLE);
        }
    }
    boolean validateData(String email, String password, String confirmPassword, boolean isStudent) {

        if(isStudent) {
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailEditText.setError("Email is invalid");
                return false;
            } else if (!email.contains("@iiitu.ac.in")) {
                emailEditText.setError("Enter your college email.");
                return false;
            }
        } else {
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailEditText.setError("Email is invalid");
                return false;
            }
        }
        if(password.length() < 6) {
            passwordEditText.setError("Password length is invalid");
            return false;
        }
        if(!password.equals(confirmPassword)) {
            confirmPasswordEditText.setError("Password not matched");
            return false;
        }
        return true;
    }
}