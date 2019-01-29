package com.example.dhruvupadhyaya.whatsappclone.Chat;

import com.example.dhruvupadhyaya.whatsappclone.User.UserObject;

import java.io.Serializable;
import java.util.ArrayList;

public class ChatObject implements Serializable {

    private String chatId;

    private ArrayList<UserObject> userObjectArrayList = new ArrayList<>();

    public ChatObject(String chatId){
        this.chatId = chatId;
    }

    public String getChatId() {
        return chatId;
    }
    public ArrayList<UserObject> getUserObjectArrayList() {
        return userObjectArrayList;
    }

    public void addUserObjectToArrayList(UserObject mUser){
        userObjectArrayList.add(mUser);
    }


}
