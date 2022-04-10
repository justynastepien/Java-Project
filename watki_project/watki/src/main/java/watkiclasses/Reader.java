package watkiclasses;

import java.lang.*;
public class Reader extends Thread {
    Library lib;
    int time;
    String key;
    int id;

    public Reader(String k, Library library, int t, int idread) {
        time = t;
        lib = library;
        key = k;
        id = idread;
    }

    public void run() {
        while (true) {

            while (!lib.inUse.containsKey(key)) {
                ;
            }
            try {
                synchronized (lib.blocade.get(key)) {
                    String text = lib.getBook(key, id);
                    System.out.println(text);//}
                    try {
                        sleep(time);
                    } catch (InterruptedException e) {
                    }
                    lib.returnBook(key, id);

                    try {
                        sleep(time);
                    } catch (InterruptedException e) {
                    }
                }
            } catch (Exception e){
                System.out.println(id);
            }
        }
    }
}
