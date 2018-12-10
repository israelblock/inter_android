package com.example.thiago.projetointerdisciplinar.repository;

import android.content.Context;

public class Repository {
    private UserRepository userRepository;
    private FriendRepository friendRepository;
    private GroupRepository groupRepository;
    private InterestRepository interestRepository;

    public Repository(Context context){
        userRepository = new UserRepository(context);
        friendRepository = new FriendRepository(context);
        groupRepository = new GroupRepository(context);
        interestRepository = new InterestRepository(context);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
    public FriendRepository getFriendRepository() {
        return friendRepository;
    }
    public GroupRepository getGroupRepository() {
        return groupRepository;
    }
    public InterestRepository getInterestRepository() {
        return interestRepository;
    }
}
