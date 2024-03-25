package com.talde1.commerceapp.model;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "settings", indices = @Index(value = {"userId"}, unique = true))
public class Settings {
    @PrimaryKey(autoGenerate = false)
    int userId;
     String direction_IP;
     String username;
     String password;

    public Settings(int userId, String direction_IP, String username, String password) {
        this.userId = userId;
        this.direction_IP = direction_IP;
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getDirection_IP() {
        return direction_IP;
    }

    public void setDirection_IP(String direction_IP) {
        this.direction_IP = direction_IP;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "id=" + userId +
                ", direction_IP='" + direction_IP + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
