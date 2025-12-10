package data.models;

import com.sun.jdi.InvalidModuleException;
import data.repositories.bookRepository;
import data.repositories.bookRepositoryImpl;
import exceptions.bookRepository.InvalidSaveException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    bookRepository bookRepository;

    @Before

    public void setup(){
        bookRepository = new bookRepositoryImpl();
    }

    @Test
    public void testNewbookRepo_IsEmpty(){
        assertEquals(0, bookRepository.count());
    }

    @Test
    public void testAddBookAndCountIsOne(){
        bookRepository.save("new book");
        assertEquals(1L, bookRepository.count());
    }

    
}