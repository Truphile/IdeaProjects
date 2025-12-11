package dtos.responses;

public class AddBookResponse {
    private int id;
    private String message;
    private String title;

    public AddBookResponse(int id, String message, String title) {
        this.id = id;
        this.message = message;
        this.title = title;
    }

    public AddBookResponse() {
        this.id = -1;
        this.message = null;
        this.title = null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.title = name;
    }

    public void setMessage(String bookAddedSuccessfully) {
        this.message = bookAddedSuccessfully;
    }
}
