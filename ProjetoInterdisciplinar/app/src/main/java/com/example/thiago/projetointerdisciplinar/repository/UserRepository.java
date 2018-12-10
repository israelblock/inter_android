package com.example.thiago.projetointerdisciplinar.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.thiago.projetointerdisciplinar.DAO.UserDAO;
import com.example.thiago.projetointerdisciplinar.database.InterDatabase;
import com.example.thiago.projetointerdisciplinar.model.Friend;
import com.example.thiago.projetointerdisciplinar.model.User;

import java.util.List;

public class UserRepository {
    private UserDAO mUserDAO;
    private List<User> mUsers;
    private List<Friend> mFriends;

    public UserRepository(Context context){
        InterDatabase db = InterDatabase.getDatabase(context);
        mUserDAO = db.UserDAO();
    }

    public List<User> getAllUsers(){
        mUsers = mUserDAO.loadUsers();
        return mUsers;
    }

    public List<Friend> loadFriend(long id){
        mFriends = mUserDAO.loadFriend(id);
        return mFriends;
    }

    public User loadUserByID(long ID) {
        return mUserDAO.loadUserByID(ID);
    }

    public User login(String email, String pass) {
        return mUserDAO.login(email, pass);
    }

    public String checkEmail(String email) {
        return mUserDAO.checkEmail(email);
    }

    public List<String> loadUserNames() {
        return mUserDAO.loadUserNames();
    }

    public void insert(User User){
        new insertAsyncTask(mUserDAO).execute(User);
    }
    public void delete(long id){mUserDAO.delete(id);}
    public void update(User User) {mUserDAO.update(User);}

    private static class insertAsyncTask extends AsyncTask<User,Void,Void> {

        private UserDAO mAsyncTaskDAO;

        insertAsyncTask(UserDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final User... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
