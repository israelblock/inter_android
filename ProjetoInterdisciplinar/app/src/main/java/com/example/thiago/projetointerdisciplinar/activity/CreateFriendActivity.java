package com.example.thiago.projetointerdisciplinar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thiago.projetointerdisciplinar.R;
import com.example.thiago.projetointerdisciplinar.global.Global;
import com.example.thiago.projetointerdisciplinar.model.Friend;
import com.example.thiago.projetointerdisciplinar.model.User;
import com.example.thiago.projetointerdisciplinar.repository.Repository;

public class CreateFriendActivity extends AppCompatActivity {

    private Repository repository;

    private EditText editTextFriendName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_friend);
        repository = new Repository(this);

        final Global global = (Global)getApplicationContext();
        final User user = global.getUser();

        Button mCreateButton = (Button) findViewById(R.id.buttonCreatFriend);
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent CreateUserView = new Intent(LoginActivity.this,CreateUserActivity.class);
                //startActivity(CreateUserView);
                editTextFriendName = (EditText) findViewById(R.id.editTextFriendName);

                String name = editTextFriendName.getText().toString();

                Friend amigo = new Friend();
                amigo.setFriendName(name);
                amigo.setUserId(user.getId());

                repository.getFriendRepository().insert(amigo);

                Intent MainView = new Intent(CreateFriendActivity.this, Main2Activity.class);
                startActivity(MainView);
            }
        });
    }
}
