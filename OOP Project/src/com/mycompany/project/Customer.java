package com.mycompany.project;

import java.io.Serializable;

public class Customer implements Serializable {
    public String name;
    public String dob;
    public String nic;
    public String phoneNo;
    public String email;
    public String password;
    public String accountType;
    public String accountNumber;
    boolean flag;

    String pastDetails[] = new String[50];
    int pastDetailsNo = 0;
    public int balance;

    void setTransactions(String type,int b) {
        type = type + "  " + String.valueOf(b);
        if(pastDetailsNo > 49){
            for(int i=0; i<49; i++) {
                pastDetails[i] = pastDetails[i+1];
            }
            pastDetails[49] = type;
        } else{
            pastDetails[pastDetailsNo] = type;
            pastDetailsNo++;
        }

    }

    public String accountNumberGenerator() {
        accountNumber = nic.substring(8) + (int)Math.floor(Math.random()*(999-100+1)+100);
        return accountNumber;
    }

    public boolean setName(String name) {
        flag = true;
        while (flag) {
            flag = false;
            for (int i=0; i<name.length(); i++) {
                if ((name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') || (name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) == 32)) {

                } else {
                    return false;
                }
            }
        }
        this.name  = name;
        return true;
    }

    public String getName() {
        return name;
    }

    public boolean setDob(String dob) {
        flag = true;
        while (flag) {
            flag = false;
            for (int i=0; i<dob.length(); i++) {
                if ((dob.charAt(i) >= '0' && dob.charAt(i) <= '9') || (dob.charAt(i) >= 'a' && dob.charAt(i) <= 'z') ||
                        (dob.charAt(i) >= 'A' && dob.charAt(i) <= 'Z') || dob.charAt(i) == '/' || dob.charAt(i) == '-') {

                } else {
                    return false;
                }
            }
        }
        this.dob  = dob;
        return true;
    }

    public String getDob() {
        return dob;
    }

    public boolean setNic(String nic) {
        flag = true;
        while (flag) {
            flag = false;
            if (nic.length() != 13) {
                return false;
            }
            for (int i=0; i<nic.length(); i++) {
                if ((nic.charAt(i) >= '0' && nic.charAt(i) <= '9')) {

                } else {
                    return false;
                }
            }
        }
        this.nic = nic;
        return true;
    }

    public String getNic() {
        return nic;
    }

    public boolean setPhoneNo(String phoneNo) {
        flag = true;
        while (flag) {
            flag = false;
            if (phoneNo.length() != 11) {
                return false;
            }
            for (int i=0; i<phoneNo.length(); i++) {
                if ((phoneNo.charAt(i) >= '0' && phoneNo.charAt(i) <= '9') || (phoneNo.charAt(i) == '-')) {

                } else {
                    return false;
                }
            }
        }
        this.phoneNo = phoneNo;
        return true;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public boolean setEmail(String email) {
        flag = true;
        while (true) {
            flag = false;
            if ((emailVerify(email))) {
                break;
            } else {
                return false;
            }
        }
        this.email = email;
        return true;
    }
    public boolean emailVerify(String email) {
        String pattern = "@email.com";
        char[] ch = email.toCharArray();
        char[] chpat = pattern.toCharArray();
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < email.length(); i++) {
            if (ch[i] == '@') {
                flag1 = true;
                for (int j = 0; j < pattern.length(); j++) {
                    if (chpat[j] != ch[i]) {
                        flag1 = false;
                        flag2 = true;
                        break;
                    }
                    i++;
                }
            } else {
                flag1 = false;
            }
            if (flag2) {
                break;
            }
        }
        if (flag1) {
            return true;
        } else {
            return false;
        }
    }

    public String getEmail() {
        return email;
    }


    public boolean setPassword(String password) {
        flag = true;
        while (flag) {
            flag = false;
            if ((verifyPassword(password))) {
                break;
            } else {
                return false;
            }
        }
        this.password = password;
        return true;
    }

    boolean verifyPassword(String password) {
        boolean L = false, a = false, A = false, D = false, S = false;
        char[] ch = password.toCharArray();
        if (password.length() > 7 && password.length() < 15)
        {
            L = true;
        }else {
            return false;
        }
        for (int i = 0; i<password.length(); i++)
        {
            if (Character.isLowerCase(password.charAt(i)))
            {
                a = true;
            }
            if (Character.isUpperCase(password.charAt(i)))
            {
                A = true;
            }
            if (Character.isDigit(password.charAt(i)))
            {
                D = true;
            }
            if ((ch[i] >= '!' && ch[i] <= '/') || (ch[i] >= ':' && ch[i] <= '@') ||
                    (ch[i] >= '[' && ch[i] <= '`') || (ch[i] >= '!' && ch[i] <= '/') ||
                    (ch[i] >= '{' && ch[i] <= '_'))
            {
                S = true;
            }
        }

        if (L == true && a == true && A == true && D == true && S == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String getPassword() {
        return password;
    }


    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

}

