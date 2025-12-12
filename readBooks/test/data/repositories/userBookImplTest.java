package data.repositories;

import data.models.Book;
import data.models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class userBookImplTest {

    private userBookImpl userBook;

    @Before
    public void setUp() {
        userBook = new userBookImpl();
    }

    @Test
    public void UponCreationOfUser_NoBookBorrowedTest() {
        userBook = new userBookImpl();
        assertEquals(0L,userBook.count());

    }

    @Test
    public void NewUserCanAddBook_BorrowedBookIsOneTest() {
        User user = new User();
        userBook.save(user);
        assertEquals(1L,userBook.count());
    }

    @Test
    public void NewUserCanAddBookTwice_BorrowedBookIsTwoTest() {
        Book book1 = new Book();
        Book  book2 = new Book();

        userBook.addBook(book1);
        userBook.addBook(book2);
        assertEquals(2L,userBook.count());
    }

    @Test
    public void UserCanAddBook_andReturnBook_BorrowedBookIsZeroTest() {
        userBook.addBook(book);
        assertEquals(1L,userBook.count());

        userBook.returnBook(book);
        assertEquals(0L,userBook.count());
    }



    }





