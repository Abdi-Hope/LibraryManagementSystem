package model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private final String name;
    private final String address;
    private final List<Book> books;
    private final List<Member> members;
    private final List<Librarian> librarians;
    private final List<Loan> loans;

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.librarians = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    // Core Management Methods
    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    // ===========================
    // ✅ New Features Start Here
    // ===========================

    // 1. Remove Book by ISBN
    public boolean removeBookByIsbn(String isbn) {
        Book bookToRemove = findBookByIsbn(isbn);
        if (bookToRemove != null) {
            return books.remove(bookToRemove);
        }
        return false;
    }

    // 2. Check if a Book is Available
    public boolean isBookAvailable(String isbn) {
        for (Loan loan : loans) {
            if (loan.getBook().getIsbn().equals(isbn)) {
                return false;
            }
        }
        return true;
    }

    // 3. Search Books by Title or Author
    public List<Book> searchBooks(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    // 4. Count Books by Author
    public int countBooksByAuthor(String author) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                count++;
            }
        }
        return count;
    }

    // 5. List Overdue Loans
    public List<Loan> getOverdueLoans() {
        List<Loan> overdue = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getDueDate().isBefore(LocalDate.now())) {
                overdue.add(loan);
            }
        }
        return overdue;
    }

    // 6. Export Library Summary to File
    public void exportSummary(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(this.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error exporting library summary: " + e.getMessage());
        }
    }

    // ===========================
    // ✅ End of New Features
    // ===========================
    @Override
    public String toString() {
        return "Library: " + name + "\nAddress: " + address + 
               "\nBooks: " + books.size() + 
               "\nMembers: " + members.size() + 
               "\nLibrarians: " + librarians.size() + 
               "\nActive Loans: " + loans.size();
    }
}