// IUserManager.aidl
package com.ft.myaidlserver;
import com.ft.myaidlserver.bean.User;

// Declare any non-default types here with import statements

interface IUserManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    List<User> getUser();
    void addUser(in User user);
}