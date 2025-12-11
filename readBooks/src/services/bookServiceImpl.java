package services;

import data.models.Book;
import data.repositories.bookRepository;
import data.repositories.bookRepositoryImpl;

import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;
import utils.Mapper;


public class bookServiceImpl implements bookService {
    bookRepository bookRepos = new bookRepositoryImpl();
    Book book = new Book();

    @Override
    public AddBookResponse addBook(AddBookRequest request) {
    Mapper.mapRequestToBook(request);
    bookRepos.save(book);
    return Mapper.mapBookDetailsToResponse(book);
        }
    }

