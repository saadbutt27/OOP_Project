package com.mycompany.project;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception, FileNotFoundException {

//        Customer ch = new Customer();
//         ch.name = "Saad";
//         ch.accountNumber = "2323423422";
//         ch.password = "Saad123!@#";
//         ch.accountType = "current";
//         ch.nic = "4220154903825";
//         ch.phoneNo = "03172122321";
//         ch.email = "s@email.com";
//         ch.dob = "27/7/2002";
//         ch.balance = 50000;
//
//        File file = new File(System.getProperty("user.dir").toString() + "\\src\\MyFiles\\UserInfo.txt");
//        ObjectOutputStream fileOutput = new ObjectOutputStream(new FileOutputStream(file));
//        fileOutput.writeObject(ch);
//        fileOutput.close();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInFrame().setVisible(true);
            }
        });
    }
}

