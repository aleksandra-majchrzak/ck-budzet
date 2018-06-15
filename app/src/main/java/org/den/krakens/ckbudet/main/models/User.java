package org.den.krakens.ckbudet.main.models;

/**
 * Created by Mohru on 15.06.2018.
 */

public class User {
    private int id;
    private String nick;

    public User(int id, String nick) {
        this.id = id;
        this.nick = nick;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
