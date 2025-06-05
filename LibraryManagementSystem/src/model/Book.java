package model;

public class Book {
    private final String isbn;
    private final String title;
    private final Author author;
    private boolean isAvailable;
    private int publishedYear;

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
    

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
    @Override
    public String toString() {
        return "Book: " + title + "\nISBN: " + isbn + "\n" + author.toString() + 
               "\nStatus: " + (isAvailable ? "Available" : "Checked Out");
    }
}