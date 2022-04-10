
import org.junit.jupiter.api.Test;

import watkiclasses.Library;
import watkiclasses.Reader;
import watkiclasses.Writer;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;


public class TestLibrary {

    private final watkiclasses.Library library = new Library();

    @Test
    void getBookTest1(){
        String text = library.getBook("Dziady", 1);
        assertEquals("Ciemno wszedzie", text);
    }

    @Test
    void getBookTest2(){
        library.getBook("Dziady", 1);
        boolean bool = library.getInUse().get("Dziady");
        assertEquals(true, bool);
    }
    @Test
    void returnBookTest(){
        String key = "Dziady";
        library.getBook(key, 1);
        library.returnBook(key, 1);
        boolean bool = library.getInUse().get(key);
        assertEquals(false, bool);
    }

    @Test
    void addBookTest(){
        String key = "Dzuma";
        library.addBook(key, "lektura", 1);
        Map<String, String>  books = library.getBooks();

        assertEquals(true, books.containsKey(key));
    }
}
