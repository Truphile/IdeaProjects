package services;

import data.repositories.bookRepository;
import data.repositories.bookRepositoryImpl;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;
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
        addBookRequest.setGenre("classics");
        addBookRequest.setIsbn(123);
        AddBookResponse response = bookService.addBook(addBookRequest);
        assertNotNull(response);
        assertEquals(1L,bookRespos.count());
    }



}