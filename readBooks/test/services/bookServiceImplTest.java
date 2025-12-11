package services;

import data.repositories.bookRepository;
import data.repositories.bookRepositoryImpl;
import dtos.requests.AddBookRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class bookServiceImplTest {

    bookService bookService = new bookServiceImpl();
    AddBookRequest addBookRequest;
    bookRepository bookRespos;
    bookService bookServices;
    @Before
    public void setup(){
        addBookRequest = new AddBookRequest();
        bookService = new bookServiceImpl();
        bookRespos = new bookRepositoryImpl();
    }

    @Test
    public void addBookTest(){
        addBookRequest.setBookName("G-strings");
        addBookRequest.setDescription("All about the writer");
        addBookRequest.setAuthor("Creed");
        addBookRequest.setEdition(1);
        addBookRequest.setQuantity(13);
        bookService.addBook(addBookRequest);
        assertEquals(1,bookRespos.getcount());
    }



}