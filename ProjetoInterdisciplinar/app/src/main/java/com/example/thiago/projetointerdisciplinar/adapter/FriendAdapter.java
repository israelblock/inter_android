package com.example.thiago.projetointerdisciplinar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.thiago.projetointerdisciplinar.R;
import com.example.thiago.projetointerdisciplinar.model.Friend;

import java.util.List;

public class FriendAdapter extends ArrayAdapter<Friend> {
    private int rId;

    public FriendAdapter(@NonNull Context context, int resource, @NonNull List<Friend> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Friend friend = getItem(position);

        TextView textNome = mView.findViewById(R.id.textNomeFriendAdapter);

        textNome.setText(friend.getFriendName().toUpperCase());

        return mView;
    }
}
