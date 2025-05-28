package model;

public class Book {
    private final String isbn;
    private final String title;
    private final Author author;
    private boolean isAvailable;

    public Book(String isbn, String title, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters and setters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book: " + title + "\nISBN: " + isbn + "\n" + author.toString() + 
               "\nStatus: " + (isAvailable ? "Available" : "Checked Out");
    }
}