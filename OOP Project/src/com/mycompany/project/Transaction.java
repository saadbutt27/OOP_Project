package com.mycompany.project;

import java.io.Serializable;

public class Transaction implements Serializable {
    public int deposit(int bal,  int b){
        if(b > 0) {
            return bal+b;
        } else {
            return -1;
        }
    }

    public int withdraw(int bal, int w) {
        if (w > 0 && w < bal) {
            bal -= w;
            return bal;
        } else {
            return -1;
        }
    }
}
