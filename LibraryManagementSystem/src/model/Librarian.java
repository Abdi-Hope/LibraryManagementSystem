package model;

public class Librarian {
    private final String staffId;
    private final String name;
    private final String contactInfo;

    public Librarian(String staffId, String name, String contactInfo) {
        this.staffId = staffId;
        this.name = name;
        this.contactInfo = contactInfo;
    }
// ...existing code...

public void createLoan(Library library, Loan loan) {
    library.addLoan(loan);
}

// ...existing code...
    // Getters and setters
    public String getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void addBookToLibrary(Library library, Book book) {
        library.addBook(book);
    }

    public void registerMember(Library library, Member member) {
        library.addMember(member);
    }

    @Override
    public String toString() {
        return "Librarian ID: " + staffId + "\nName: " + name + "\nContact: " + contactInfo;
    }
}