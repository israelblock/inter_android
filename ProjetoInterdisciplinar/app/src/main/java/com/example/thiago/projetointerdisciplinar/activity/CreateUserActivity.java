package com.example.thiago.projetointerdisciplinar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thiago.projetointerdisciplinar.R;
import com.example.thiago.projetointerdisciplinar.global.Global;
import com.example.thiago.projetointerdisciplinar.model.User;
import com.example.thiago.projetointerdisciplinar.repository.Repository;

public class CreateUserActivity extends AppCompatActivity {

    private Repository repository;

    private EditText mPasswordView;
    private EditText mNameView;
    private EditText mEmailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        repository = new Repository(this);

        Button mCreateButton = (Button) findViewById(R.id.button_create_user);
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent CreateUserView = new Intent(LoginActivity.this,CreateUserActivity.class);
                //startActivity(CreateUserView);
                mPasswordView = (EditText) findViewById(R.id.editText4);
                mNameView = (EditText) findViewById(R.id.editText2);
                mEmailView = (EditText) findViewById(R.id.editText3);

                mEmailView.setError(null);
                mPasswordView.setError(null);
                mNameView.setError(null);

                String name = mNameView.getText().toString();
                String pass = mPasswordView.getText().toString();
                String email = mEmailView.getText().toString();

                View focusView = null;
                boolean cancel = false;

                String emailExist = repository.getUserRepository().checkEmail(email);

                // Check for a valid password, if the user entered one.
                if (TextUtils.isEmpty(pass) || pass.length() < 4) {
                    mPasswordView.setError(getString(R.string.error_invalid_password));
                    focusView = mPasswordView;
                    cancel = true;
                }

                // Check for a valid user name, if the user entered one.
                if (TextUtils.isEmpty(name)) {
                    mNameView.setError("Nome Inválido");
                    focusView = mNameView;
                    cancel = true;
                }

                // Check for a valid email address.
                if (TextUtils.isEmpty(email)) {
                    mEmailView.setError(getString(R.string.error_field_required));
                    focusView = mEmailView;
                    cancel = true;
                } else if (!isEmailValid(email)) {
                    mEmailView.setError(getString(R.string.error_invalid_email));
                    focusView = mEmailView;
                    cancel = true;
                } else if(emailExist != null){
                    mEmailView.setError("Email já cadastrado");
                    focusView = mEmailView;
                    cancel = true;
                }

                if (cancel) {
                    focusView.requestFocus();
                } else {

                    User novo = new User();
                    novo.setEmail(email);
                    novo.setPass(pass);
                    novo.setName(name);

                    Global global = (Global)getApplicationContext();
                    global.setUser(novo);

                    repository.getUserRepository().insert(novo);

                    Intent MainView = new Intent(CreateUserActivity.this,Main2Activity.class);
                    startActivity(MainView);
                }
            }
        });
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
}
