package com.example.thiago.projetointerdisciplinar.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.thiago.projetointerdisciplinar.DAO.FriendDAO;
import com.example.thiago.projetointerdisciplinar.database.InterDatabase;
import com.example.thiago.projetointerdisciplinar.model.Friend;

public class FriendRepository {
    private FriendDAO mFriendDAO;

    public FriendRepository(Context context){
        InterDatabase db = InterDatabase.getDatabase(context);
        mFriendDAO = db.FriendDAO();
    }

    public void insert(Friend Friend){
        new insertAsyncTask(mFriendDAO).execute(Friend);
    }
    public void delete(long id){mFriendDAO.delete(id);}

    private static class insertAsyncTask extends AsyncTask<Friend,Void,Void> {

        private FriendDAO mAsyncTaskDAO;

        insertAsyncTask(FriendDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Friend... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
