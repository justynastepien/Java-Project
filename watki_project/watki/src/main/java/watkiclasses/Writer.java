package watkiclasses;

import java.lang.*;

public class Writer extends Thread{
    final Library lib;
    int time;
    String key;
    String value;
    int id;

    public Writer(String k, String v, int t, Library library, int idwrit){
        lib = library;
        time = t;
        key = k;
        value = v;
        id = idwrit;
    }

    public void run(){
        while(true) {
            lib.addBook(key, value, id);
            try {
                sleep(time);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            key = key + "cd";

            try {
                sleep(time);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
