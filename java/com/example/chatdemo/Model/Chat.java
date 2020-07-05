package com.example.chatdemo.Model;

import android.text.format.DateFormat;

import com.google.firebase.database.core.Constants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Chat {
    private String sender;
    private String receiver;
    private String message;
    private boolean isseen;
    private String messagetime;

    public Chat(String sender, String receiver, String message, boolean isseen,String messagetime) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.isseen = isseen;
        this.messagetime=messagetime;

    }

    public Chat() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIsseen() {
        return isseen;
    }

    public void setIsseen(boolean isseen) {
        this.isseen = isseen;
    }

    public String getMessagetime() {
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM(HH:mm)");
        messagetime=format.format(date);
        return messagetime;
    }

        public void setMessagetime(String messagetime) {
        this.messagetime = messagetime;
    }
}
