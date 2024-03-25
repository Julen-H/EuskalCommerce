package com.talde1.commerceapp.repos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.talde1.commerceapp.dao.DBAccess;
import com.talde1.commerceapp.dao.UserDAO;
import com.talde1.commerceapp.model.User;


import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UsersRepo {
    UserDAO userDAO;
    Executor executor = Executors.newSingleThreadExecutor();

    public UsersRepo(Application application){
        userDAO = DBAccess.obtainInstance(application).getUserDAO();
    }

    public LiveData<User> get(String user){ return userDAO.getUser(user); }

    public String getPasswordLogin(String user){ return userDAO.getPasswordLogin(user); }

    public int getUserId(String user){ return userDAO.getUserId(user); }

    public void insert(User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.insert(user);
            }
        });
    }

    public void delete(User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.delete(user);
            }
        });
    }

    public void update(User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.update(user);
            }
        });
    }
}
