package com.example.thiago.projetointerdisciplinar.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.thiago.projetointerdisciplinar.DAO.InterestDAO;
import com.example.thiago.projetointerdisciplinar.database.InterDatabase;
import com.example.thiago.projetointerdisciplinar.model.Interest;

public class InterestRepository {
    private InterestDAO mInterestDAO;

    public InterestRepository(Context context){
        InterDatabase db = InterDatabase.getDatabase(context);
        mInterestDAO = db.InterestDAO();
    }

    public void insert(Interest Interest){
        new insertAsyncTask(mInterestDAO).execute(Interest);
    }
    public void update(Interest Interest) {mInterestDAO.update(Interest);}

    private static class insertAsyncTask extends AsyncTask<Interest,Void,Void> {

        private InterestDAO mAsyncTaskDAO;

        insertAsyncTask(InterestDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Interest... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
