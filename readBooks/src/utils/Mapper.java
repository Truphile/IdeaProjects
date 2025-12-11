package utils;

import data.models.Book;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;

public  class Mapper {
    public static Book mapRequestToBook(AddBookRequest request) {
        if (request == null) return null;

        Book book = new Book();

        book.setAuthor(request.getAuthor());
        book.setEdition(request.getEdition());
        book.setDescription(request.getDescription());
        book.setQuantity(request.getQuantity());
        book.setName(request.getBookName());
        book.setGenre(request.getGenre());
        book.setIsbn(request.getIsbn());

        return book;
    }



    public static AddBookResponse mapBookDetailsToResponse(Book book) {
        if (book == null) return null;

        AddBookResponse response = new AddBookResponse();

        response.setId(book.getId());
        response.setName(book.getName());
        response.setMessage("Book added successfully");

        return response;
}


}





