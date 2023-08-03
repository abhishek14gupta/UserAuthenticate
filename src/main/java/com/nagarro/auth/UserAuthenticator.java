package com.nagarro.auth;

import java.util.HashMap;
import java.util.Map;

public class UserAuthenticator {
    private final Map<String, String> users;

    public UserAuthenticator() {
        // Initialize the user credentials (replace this with your real authentication logic)
        users = new HashMap<>();
        users.put("user1", "pass1");
        users.put("user2", "pass2");
        users.put("abhishek","abhi@123");
        users.put("root","root");
    }

    public boolean authenticate(String userId, String password) {
        String storedPassword = users.get(userId);
        return storedPassword != null && storedPassword.equals(password);
    }
}

