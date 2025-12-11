package data.repositories;

import data.models.borrowedBook;
import data.repositories.borrowedBookRepository;
import data.repositories.borrowedBookRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class borrowedBookRepositoryImplTest {

    private borrowedBookRepository borrowedRepo;
    private borrowedBook borrowedBooks;

        @Before
        public void setUp() {
            borrowedRepo = new borrowedBookRepositoryImpl();
        }

        @Test
        public void testRepositoryStartsEmpty() {
            assertEquals(0, borrowedRepo.count());
        }

        @Test
        public void testSaveNewBorrowedBook_AssignsId() {
            borrowedBooks = new borrowedBook();
            borrowedRepo.save(borrowedBooks);

            assertEquals(1, borrowedRepo.count());
            assertEquals(1, borrowedBooks.getId());
        }

        @Test
        public void testFindById_ReturnsCorrectBorrowedBook() {
            borrowedBooks = new borrowedBook();
            borrowedBooks.setTitle("How to win Hacker House");

            borrowedRepo.save(borrowedBooks);

            borrowedBook found = borrowedRepo.findById(1);

            assertNotNull(found);
            assertEquals("How to win Hacker House", found.getTitle());
        }

        @Test
        public void testSaveNull_DoesNothing() {
            borrowedRepo.save(null);
            assertEquals(0, borrowedRepo.count());
        }

        @Test
        public void testUpdateBorrowedBook_ReplacesOldRecord() {
            borrowedBook b1 = new borrowedBook();
            b1.setTitle("Old Title");
            borrowedRepo.save(b1);

            borrowedBook updated = new borrowedBook();
            updated.setId(1);
            updated.setTitle("New Title");

            borrowedRepo.save(updated);
            borrowedBook found = borrowedRepo.findById(1);

            assertEquals("New Title", found.getTitle());
            assertEquals(1, borrowedRepo.count());
        }

        @Test
        public void testDeleteById_RemovesRecord() {
            borrowedBook b1 = new borrowedBook();
            borrowedRepo.save(b1);

            borrowedRepo.deleteById(1);

            assertEquals(0, borrowedRepo.count());
            assertNull(borrowedRepo.findById(1));
        }

        @Test
        public void testSaveMultiple_AssignsSequentialIds() {
            borrowedBook b1 = new borrowedBook();
            borrowedBook b2 = new borrowedBook();
            borrowedBook b3 = new borrowedBook();

            borrowedRepo.save(b1);
            borrowedRepo.save(b2);
            borrowedRepo.save(b3);

            assertEquals(1, b1.getId());
            assertEquals(2, b2.getId());
            assertEquals(3, b3.getId());
            assertEquals(3, borrowedRepo.count());
        }
    }