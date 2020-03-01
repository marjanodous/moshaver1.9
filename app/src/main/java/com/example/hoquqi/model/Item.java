package com.example.hoquqi.model;

public class Item {

    /*1.model fields*/
    private String uMessage;

    /*2. constructors*/
    public Item() {
    }
    public Item(String uMessage) {
        this.uMessage = uMessage;
    }

    /*3.get and set*/
    public String getuMessage() {
        return uMessage;
    }
    public void setuMessage(String uMessage) {
        this.uMessage = uMessage;
    }


}
