package com.example.emailclientprod.controller;

import com.example.emailclientprod.EmailManager;
import com.example.emailclientprod.ViewFactory;

public abstract class BaseController {

    protected EmailManager emailManager;
    protected ViewFactory viewFactory;
    private String fxmlName;

    public BaseController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        this.emailManager = emailManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFXMLName() {
        return fxmlName;
    }
}
