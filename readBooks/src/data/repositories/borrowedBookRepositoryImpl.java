package data.repositories;

import data.models.borrowedBook;

import java.util.ArrayList;
import java.util.List;

public class borrowedBookRepositoryImpl implements borrowedBookRepository {

    private List<borrowedBook> borrowedBooks = new ArrayList<>();
    private int count;

    @Override
    public int count() {
        return borrowedBooks.size();
    }

    @Override
    public borrowedBook save(borrowedBook borrowedBook) {
        if (borrowedBook == null) {
            return null;
        }

        if (borrowedBook.getId() == 0) {
            count++;
            borrowedBook.setId(count);
            borrowedBooks.add(borrowedBook);
            return borrowedBook;
        }
       return update(borrowedBook);
    }

    private borrowedBook update(borrowedBook borrowedBook) {
        borrowedBooks.removeIf(b -> b.getId() == borrowedBook.getId());
        borrowedBooks.add(borrowedBook);
        return borrowedBook;
    }


    @Override
    public void deleteById(int id) {
        borrowedBooks.remove(findById(id));

    }

    @Override
    public borrowedBook findById(int id) {
        for (borrowedBook borrowedBook : borrowedBooks) {
            if (borrowedBook.getId() == id) {
            }
            return borrowedBook;
        }
        return null;
    }
}
