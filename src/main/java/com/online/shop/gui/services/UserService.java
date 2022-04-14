package com.online.shop.gui.services;

import com.online.shop.gui.component.User;

import java.io.*;
import java.util.Properties;

public class UserService{
    Properties properties=new Properties();
    FileReader fileReader;
    {
        try {
            fileReader = new FileReader("src/main/resources/_testdata.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User setUserData(){
        User user= new User();
        try {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setEmail(properties.get("user1.email").toString());
        user.setPassword(properties.get("user.password").toString());
        user.setName(properties.get("user.name").toString());
        return user;
    }


}
