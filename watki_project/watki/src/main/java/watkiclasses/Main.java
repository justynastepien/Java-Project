package watkiclasses;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        new Writer("Krzyzacy", "za siedmioma gorami", 4200, library, 1).start();
        new Writer("Potop", "za siedmioma lasami", 5308, library, 2).start();
        new Writer("Quo Vadis", "za siedmioma rzekami", 4800, library, 3).start();

        new Reader("Dziady", library, 4200, 1).start();
        new Reader("Opowiadanie", library, 5308, 2).start();
        new Reader("Dziady", library, 2083, 3).start();
        new Reader("Potop", library, 4100, 4).start();
        new Reader("Quo Vadis", library, 6352, 5).start();
        new Reader("Krzyzacy", library, 4200, 6).start();
        new Reader("Krzyzacy", library, 5308, 7).start();
        new Reader("Quo Vadis", library, 2083, 8).start();
        new Reader("Opowiadanie", library, 4100, 9).start();
        new Reader("Potop", library, 6352, 10).start();


    }
}
