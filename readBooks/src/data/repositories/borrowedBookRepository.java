package data.repositories;

import data.models.borrowedBook;

public interface borrowedBookRepository {
    int count();

    borrowedBook save(borrowedBook borrowedBook);


    void deleteById(int id);

    borrowedBook findById(int id);
}
