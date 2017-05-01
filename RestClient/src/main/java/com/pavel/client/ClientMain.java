package com.pavel.client;

import com.pavel.client.view.frame.StudentsFrame;

import java.net.MalformedURLException;

/**
 * класс для открытия главного окна клиента
 */
public class ClientMain {
    public static void main(String[] args) throws MalformedURLException {
        StudentsFrame studentsFrame = new StudentsFrame();
        studentsFrame.setVisible(true);

    }
}
