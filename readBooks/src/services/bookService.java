package services;

import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;

public interface bookService {
    AddBookResponse addBook(AddBookRequest request);
}
