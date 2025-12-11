package data.repositories;

import data.models.Book;

public interface bookRepository {
    Book save(Book book);

    long count();

    Book findById(int i);

    void deleteById(int id);
}
