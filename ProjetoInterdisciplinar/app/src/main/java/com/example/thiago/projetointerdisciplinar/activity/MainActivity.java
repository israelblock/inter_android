package com.example.thiago.projetointerdisciplinar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thiago.projetointerdisciplinar.R;
import com.example.thiago.projetointerdisciplinar.global.Global;
import com.example.thiago.projetointerdisciplinar.model.User;
import com.example.thiago.projetointerdisciplinar.repository.Repository;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private TextView mTextMessage;
    private ListView friendList;
    private ListView groupList;
    ArrayAdapter<User> adapter;

    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository = new Repository(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTextMessage = (TextView) findViewById(R.id.message);

        //mTextMessage.setText(R.string.title_home);
        Global global = (Global)getApplicationContext();
        mTextMessage.setText(global.getUser().getName());

        friendList = (ListView) findViewById(R.id.friendList);
        groupList = (ListView) findViewById(R.id.groupList);
        friendList.setOnItemClickListener(this);

        Button mConfigButton = (Button) findViewById(R.id.button_config);
        mConfigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent EditView = new Intent(MainActivity.this,EditUserActivity.class);
                startActivity(EditView);
            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
