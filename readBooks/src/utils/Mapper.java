package utils;

import data.models.Book;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;

public class Mapper {
    public static void mapRequestToBook(AddBookRequest request) {
        request.setAuthor();
        request.setEdition();
        request.setDescription();
        request.setQuantity();
        request.setBookName();
        request.SetGenre();
        request.setIsbn();

    }

    public static AddBookResponse mapBookDetailsToResponse(Book book) {
        return null;
    }
}
