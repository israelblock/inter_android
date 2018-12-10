package com.example.thiago.projetointerdisciplinar.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.thiago.projetointerdisciplinar.DAO.GroupDAO;
import com.example.thiago.projetointerdisciplinar.database.InterDatabase;
import com.example.thiago.projetointerdisciplinar.model.Group;

import java.util.List;

public class GroupRepository {
    private GroupDAO mGroupDAO;
    private List<Group> mGroups;

    public GroupRepository(Context context){
        InterDatabase db = InterDatabase.getDatabase(context);
        mGroupDAO = db.GroupDAO();
    }

    public List<Group> loadGroupByUser(Long id){
        mGroups = mGroupDAO.loadGroupByUser(id);
        return mGroups;
    }

    public void insert(Group Group){
        new insertAsyncTask(mGroupDAO).execute(Group);
    }
    public void delete(long id){mGroupDAO.delete(id);}
    public void update(Group Group) {mGroupDAO.update(Group);}

    private static class insertAsyncTask extends AsyncTask<Group,Void,Void> {

        private GroupDAO mAsyncTaskDAO;

        insertAsyncTask(GroupDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Group... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
