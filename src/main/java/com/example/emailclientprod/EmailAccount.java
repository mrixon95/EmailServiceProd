package com.example.emailclientprod;

import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class EmailAccount {

    private String address;
    private String password;
    private Properties properties;
    private Store store;
    private Session session;

    public EmailAccount(String address, String password) {
        this.address = address;
        this.password = password;
        properties= new Properties();
        properties.put("incomingHost", "imap.googlemail.com");
        properties.put("imap.googlemail.com", "imaps");
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.host", "smpt.gmail.com");
        properties.put("mail.smtps.auth", "true");
        properties.put("outgoingHost","smtp.gmail.com");


    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    @Override
    public String toString() {
        return address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }


    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}
