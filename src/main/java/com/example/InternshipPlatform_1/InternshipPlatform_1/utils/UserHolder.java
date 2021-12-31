package com.example.InternshipPlatform_1.InternshipPlatform_1.utils;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;

public class UserHolder {

    private final static ThreadLocal<User> requestHolder = new ThreadLocal<>();
    public static void add(User user) {
        requestHolder.set(user);
    }

    public static User getUser() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }

}
