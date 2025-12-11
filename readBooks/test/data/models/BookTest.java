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

        Book book;
        bookRepository bookRepository;

        @Before
        public void setup() {
            bookRepository = new bookRepositoryImpl();
            book = new Book();
        }

        @Test
        public void testNewBookRepo_IsEmpty() {
            assertEquals(0, bookRepository.count());
        }

        @Test
        public void testAddBookAndCountIsOne() {
            bookRepository.save(book);
            assertEquals(1L, bookRepository.count());
        }

        @Test
        public void testSaveBook_FindBookId_returnBook() {
            bookRepository.save(book);

            Book found = bookRepository.findById(1);

            assertNotNull(found);
            assertEquals(1, found.getId());
        }

        @Test
        public void testAddBook_DoesNotIncreaseCount_IfNull() {
            book = null;
            bookRepository.save(book);

            assertEquals(0L, bookRepository.count());
        }

        @Test
        public void testSaveBookCount_IsOne_DeleteBook_CountZero(){
            Book bookOne = new Book();
            bookRepository.save(bookOne);
            assertEquals(1,bookRepository.count());

            bookRepository.deleteById(bookOne.getId());
            assertEquals(0, bookRepository.count());




        }
}

