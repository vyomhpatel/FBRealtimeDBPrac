package b12app.vyom.com.firebaserealtimedatabasepractice;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.concurrent.atomic.AtomicInteger;

@IgnoreExtraProperties
public class User {
    private static final AtomicInteger count = new AtomicInteger(0);
    public String username;
    public String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}