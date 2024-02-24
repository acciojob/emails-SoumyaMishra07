package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    private int inboxCapacity;
    private ArrayList<Mail> inbox;
    private ArrayList<Mail> trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        if (inbox.size() >= inboxCapacity) {
            trash.add(inbox.remove(0));
        }
        inbox.add(new Mail(date, sender, message));
    }

    public void deleteMail(String message){
        inbox.removeIf(mail -> mail.getMessage().equals(message));
    }

    public String findLatestMessage(){
        return inbox.isEmpty() ? null : inbox.get(inbox.size() - 1).getMessage();
    }

    public String findOldestMessage(){
        return inbox.isEmpty() ? null : inbox.get(0).getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end){
        int count = 0;
        for (Mail mail : inbox) {
            if (mail.getDate().after(start) && mail.getDate().before(end)) {
                count++;
            }
        }
        return count;
    }

    public int getInboxSize(){
        return inbox.size();
    }

    public int getTrashSize(){
        return trash.size();
    }

    public void emptyTrash(){
        trash.clear();
    }

    public int getInboxCapacity() {
        return inboxCapacity;
    }

    private static class Mail {
        private Date date;
        private String sender;
        private String message;

        public Mail(Date date, String sender, String message) {
            this.date = date;
            this.sender = sender;
            this.message = message;
        }

        public Date getDate() {
            return date;
        }

        public String getSender() {
            return sender;
        }

        public String getMessage() {
            return message;
        }
    }
}