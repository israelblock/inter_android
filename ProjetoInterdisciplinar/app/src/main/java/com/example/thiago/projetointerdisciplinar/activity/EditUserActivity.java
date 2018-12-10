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

public class EditUserActivity extends AppCompatActivity {

    private Repository repository;

    private EditText mPasswordView;
    private EditText mNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        repository = new Repository(this);

        final Global global = (Global)getApplicationContext();

        final User user = global.getUser();

        mPasswordView = (EditText) findViewById(R.id.editText4edit);
        mNameView = (EditText) findViewById(R.id.editText2edit);

        mNameView.setText(user.getName());
        mPasswordView.setText(user.getPass());

        Button mCreateButton = (Button) findViewById(R.id.button_edit_user);
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent CreateUserView = new Intent(LoginActivity.this,CreateUserActivity.class);
                //startActivity(CreateUserView);

                mPasswordView.setError(null);
                mNameView.setError(null);

                String name = mNameView.getText().toString();
                String pass = mPasswordView.getText().toString();

                View focusView = null;
                boolean cancel = false;

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

                if (cancel) {
                    focusView.requestFocus();
                } else {

                    user.setPass(pass);
                    user.setName(name);

                    global.setUser(user);

                    repository.getUserRepository().update(user);

                    Intent MainView = new Intent(EditUserActivity.this,Main2Activity.class);
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
