package com.mycompany.project;

import java.io.*;

public class MyFiler {

    static boolean setUser(Customer obj){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(System.getProperty("user.dir").toString() + "\\src\\MyFiles\\CurrentUser.txt")));
            oos.writeObject(obj);
            oos.close();
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public static Customer getUser(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(System.getProperty("user.dir").toString() + "\\src\\MyFiles\\CurrentUser.txt")));
            Customer myCustomer = (Customer)ois.readObject();
            return myCustomer;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static boolean readFile(Customer customers[]){
        File file = new File(System.getProperty("user.dir").toString() + "\\src\\MyFiles\\UserInfo.txt");
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            for(int i=0; i<50; i++){
                customers[i] = (Customer)ois.readObject();
            }
            ois.close();
            return true;
        } catch (EOFException e){
            System.out.println(e + "File Reading Ends here");
            return true;
        } catch (Exception e){
            System.out.println(e + "Not present here");
            return false;
        }
    }

    public static boolean myAppendObject(Customer obj,Customer customers[]){
        try{
            File myFile = new File(System.getProperty("user.dir").toString() + "\\src\\MyFiles\\UserInfo.txt");
            MyObjectOutputStream oos = new MyObjectOutputStream(new FileOutputStream(myFile,true));
            oos.writeObject(obj);
            readFile(customers);
            oos.close();
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public static void changeObject(Customer obj,Customer customers[]){
        File file = new File(System.getProperty("user.dir").toString() + "\\src\\MyFiles\\UserInfo.txt");
        readFile(customers);
        try{
            for (int i=0; i<50; i++){
                if((customers[i].accountNumber.compareTo(obj.accountNumber)) == 0){
                    customers[i] = obj;
                    System.out.println("Object transferred " + i);
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }

        try{
            FileWriter foo = new FileWriter(file);
            foo.write("");
            foo.close();
        } catch (Exception e){
            System.out.println(e);
        }

        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file,true));
            for(int i=0; i<50; i++) {
                if(customers[i] == null){
                    oos.close();
                    break;
                }
                oos.writeObject(customers[i]);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
