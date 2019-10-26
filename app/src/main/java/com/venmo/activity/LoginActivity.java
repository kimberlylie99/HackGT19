package com.venmo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.venmo.R;

public class LoginActivity extends AppCompatActivity{

    private static final int REQUEST_READ_CONTACTS = 0;

    private UserLogin authTask = null;

    // UI references.
    private EditText usernameView;
    private EditText passwordView;
    private Button login_btn;
    private View progressView;
    private View loginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        populateAutoComplete();
    }

    public class UserLogin {
        private final String currentEmail;
        private final String currentPassword;
        private final LoginActivity activity;

        UserLogin(String email, String password, LoginActivity activity) {
            this.currentEmail = email;
            this.currentPassword = password;
            this.activity = activity;
        }
    }

    private void populateAutoComplete() {
        usernameView = findViewById(R.id.username);
        passwordView = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(usernameView.getText().toString().equals("admin") && passwordView.getText().toString().equals("admin")) {
                            startActivity(new Intent(LoginActivity.this, UserPaymentActivity.class));
                        }
                    }
                }
        );
    }
}
