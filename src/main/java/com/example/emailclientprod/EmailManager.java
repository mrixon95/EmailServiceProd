package com.example.emailclientprod;

import com.example.emailclientprod.controller.EmailTreeItem;
import javafx.scene.control.TreeItem;

// has account properties for send and receiving emails IMAP (sending) and SMTP (receiving)
public class EmailManager {
    // Folder handling
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");

    public TreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    public void addEmailAccount(EmailAccount emailAccount) {
        EmailTreeItem<String> treeItem = new EmailTreeItem<>(emailAccount.getAddress());
        FetchFoldersService fetchFoldersService = new FetchFoldersService(emailAccount.getStore(), treeItem);
        fetchFoldersService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
