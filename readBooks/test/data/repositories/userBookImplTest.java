package data.repositories;

import data.models.Book;
import data.models.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        User book1 = new User();
        User  book2 = new User();

        userBook.save(book1);
        userBook.save(book2);
        assertEquals(2L,userBook.count());
    }

    @Test
    public void UserCanAddBook_andReturnBook_BorrowedBookIsZeroTest() {
        User user = new User();
        userBook.save(user);
        assertEquals(1L,userBook.count());

        userBook.delete(user);
        assertEquals(0L,userBook.count());
    }

    @Test
    public void UserCanBorrowTwoBooks_ReturnOneBook_BorrowedBookIsOneTest() {
        User user = new User();
        User book1 = new User();
        userBook.save(user);
        userBook.save(book1);
        assertEquals(2L,userBook.count());

        userBook.delete(book1);
        assertEquals(1L,userBook.count());
    }

    @Test
    public void UserCanBorrowTwoBooks_ReturnTwoBooks_BorrowedBookIsTwoTest() {
        User user = new User();
        User book1 = new User();
        userBook.save(user);
        userBook.save(book1);
        assertEquals(2L,userBook.count());

        userBook.delete(book1);
        userBook.delete(user);
        assertEquals(0L,userBook.count());
    }

    @Test
    public void UserCanFindBookByIdTest() {
        User user = new User();
        userBook.save(user);
        assertEquals(1L,userBook.count());

        assertEquals(user, userBook.findById(user.getId()));
    }

    @Test
    public void UserCanDeleteBookByIdTest() {
        User user = new User();
        userBook.save(user);
        assertEquals(1L,userBook.count());

        assertEquals(user, userBook.deleteById(user.getId()));
    }
    @Test
    public void UserCanfindAllBooks() {
        User user = new User();
        userBook.save(user);
        assertEquals(1L,userBook.count());

        User user2 = new User();
        userBook.save(user2);
        assertEquals(2L,userBook.count());

        User user3 = new User();
        userBook.save(user3);
        assertEquals(3L,userBook.count());

        assertEquals(userBook.count(), userBook.findAll().size());
    }

    @Test
    public void UserCanDeleteAllBooks(){
        User user = new User();
        userBook.save(user);
        User user2 = new User();
        userBook.save(user2);
        User user3 = new User();
        userBook.save(user3);
        assertEquals(3L,userBook.count());

        assertEquals(0, userBook.deleteAll().size());
    }

    @Test
    public void UserCanCheckIfBookExists_ReturnTrue() {
        User user = new User();
        userBook.save(user);
     assertTrue(userBook.checkIfBookExists(user.getId()));

    }



    }





