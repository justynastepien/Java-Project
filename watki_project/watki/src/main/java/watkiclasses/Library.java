package watkiclasses;

import java.util.HashMap;
import java.util.*;
import java.lang.Object;

public class Library {
    Map<String, String> books = new HashMap<>();
    Map<String, Boolean> inUse = new HashMap<>();
    Map<String, Object> blocade = new HashMap<>();
    int readers = 0;

    public Library() {
        books.put("Dziady", "Ciemno wszedzie");
        inUse.put("Dziady", false);
        blocade.put("Dziady", new Object());

        books.put("Opowiadanie", "Dawno dawno temu");
        inUse.put("Opowiadanie", false);
        blocade.put("Opowiadanie", new Object());
    }

    public synchronized Integer getReaders() {
        return readers;
    }

    public synchronized Map<String, Boolean> getInUse() {
        return inUse;
    }

    public synchronized Map<String, String> getBooks() {
        return books;
    }

    public synchronized String getBook(String key, int id) {
        synchronized (blocade.get(key)) {
            while(readers>=5||(inUse.containsKey(key)&&inUse.get(key).equals(true))||!inUse.containsKey(key)){
                try{
                    wait();
                }
                catch(InterruptedException e) {
                    System.err.println(e);
                }
            }

            for(Map.Entry<String, String> book : books.entrySet()) {
                if (key.equals(book.getKey()))
                    if (inUse.get(key).equals(false)) {

                        System.out.println("czytelnik nr " + id + " wchodzi do biblioteki");
                        inUse.replace(key, true);
                        readers++;
                        return book.getValue();
                    }
            }
        }
        return null;

    }

    public synchronized void returnBook(String k, int id){
        synchronized (blocade.get(k)) {
            inUse.replace(k, false);
            readers--;
            System.out.println("czytelnik nr " + id + " wychodzi z biblioteki");
        }
        notifyAll();
    }

    public synchronized void addBook(String k, String v, int id){
        while(readers > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        synchronized(this) {
            System.out.println("Pisarz nr " + id + " wchodzi do biblioteki");
            blocade.put(k, new Object());
            books.put(k, v);
            inUse.put(k, false);

            System.out.println("Pisarz nr "+ id + " napisal ksiazke");
            System.out.println("Pisarz nr "+ id + " wychodzi z biblioteki");
            notifyAll();
        }

    }

}
