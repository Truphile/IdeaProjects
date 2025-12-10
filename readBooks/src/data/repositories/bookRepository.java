package data.repositories;

import data.models.Book;

public interface bookRepository {
    int count();

    Book save(String newBook);
}
