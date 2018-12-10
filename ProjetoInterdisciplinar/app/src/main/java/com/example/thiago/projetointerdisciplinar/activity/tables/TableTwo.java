package com.example.thiago.projetointerdisciplinar.activity.tables;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.thiago.projetointerdisciplinar.R;
import com.example.thiago.projetointerdisciplinar.activity.CreateFriendActivity;
import com.example.thiago.projetointerdisciplinar.adapter.FriendAdapter;
import com.example.thiago.projetointerdisciplinar.global.Global;
import com.example.thiago.projetointerdisciplinar.model.Friend;
import com.example.thiago.projetointerdisciplinar.model.User;
import com.example.thiago.projetointerdisciplinar.repository.Repository;

import java.util.List;

public class TableTwo extends android.app.Fragment implements AdapterView.OnItemClickListener{

    private Repository repository;
    private ListView friendList;
    ArrayAdapter<Friend> adapterFriend;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.tab_two, container, false);
        repository = new Repository(getActivity().getApplicationContext());

        Button mCreateButton = (Button) view.findViewById(R.id.buttonAddFriend);
        friendList = (ListView) view.findViewById(R.id.friendListTableOne);
        friendList.setOnItemClickListener(this);

        if(mCreateButton != null){
            mCreateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent MainView = new Intent(getActivity(), CreateFriendActivity.class);
                    startActivity(MainView);
                }
            });
        }

        atualizarAmigos();
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        final Global global = (Global)getActivity().getApplicationContext();
        final User user = global.getUser();

        final List<Friend> friends = repository.getUserRepository().loadFriend(user.getId());
         final int newI = i;
        //List<Friend> f = (List<Friend>) adapterView.getItemAtPosition(i);
        //final UserDAO.FriendJoin friendJoin = (UserDAO.FriendJoin) adapterView.getItemAtPosition(i);

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("O que fazer com " + friends.get(i).getFriendName()).setItems(R.array.opcoes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if(which == 0) {
                    repository.getFriendRepository().delete(friends.get(newI).getId());
                    atualizarAmigos();
                }
            }
        }).create().show();
    }

    private void atualizarAmigos(){
        final Global global = (Global)getActivity().getApplicationContext();
        final User user = global.getUser();

        List<Friend> friends = repository.getUserRepository().loadFriend(user.getId());
        if(friends.size() > 0){
            adapterFriend = new FriendAdapter(getActivity().getApplicationContext(), R.layout.friend_item, friends);
            friendList.setAdapter(adapterFriend);
        }
    }
}
