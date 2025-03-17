package com.tariqtesting;

import javax.swing.JOptionPane;

public class MessageNotification implements Notification {
    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }




}
