package data.repositories;

import data.models.Book;

public interface bookRepository {
    Book save(Book book);

    long count();

    Book findById(int id);

    void deleteById(int id);


}
