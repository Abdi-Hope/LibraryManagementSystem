import java.time.LocalDate;
import model.Author;
import model.Book;
import model.Librarian;
import model.Library;
import model.Loan;
import model.Member;

public class Main {
    public static void main(String[] args) {
        // Create a library
        Library cityLibrary = new Library("City Central Library", "123 Library St.");

        // Create a librarian
        Librarian headLibrarian = new Librarian("LIB001", "Sarah Johnson", "sarah@library.com");
        cityLibrary.addLibrarian(headLibrarian);

        // Add some authors
        Author author1 = new Author("J.K. Rowling", "British author best known for the Harry Potter series");
        Author author2 = new Author("George Orwell", "English novelist known for 1984 and Animal Farm");

        // Add some books
        Book book1 = new Book("978-0439064873", "Harry Potter and the Chamber of Secrets", author1);
        Book book2 = new Book("978-0451524935", "1984", author2);

        headLibrarian.addBookToLibrary(cityLibrary, book1);
        headLibrarian.addBookToLibrary(cityLibrary, book2);

        // Register some members
        Member member1 = new Member("MEM001", "John Doe", "john@email.com");
        Member member2 = new Member("MEM002", "Jane Smith", "jane@email.com");

        headLibrarian.registerMember(cityLibrary, member1);
        headLibrarian.registerMember(cityLibrary, member2);

        // Create a loan
        Loan loan1 = new Loan(book1, member1, LocalDate.now(), LocalDate.now().plusWeeks(2));
        cityLibrary.addLoan(loan1);
        member1.borrowBook(book1);

        // Display library information
        System.out.println("=== LIBRARY INFORMATION ===");
        System.out.println(cityLibrary);
        System.out.println("\n=== LIBRARIAN ===");
        System.out.println(headLibrarian);
        System.out.println("\n=== MEMBERS ===");
        for (Member member : cityLibrary.getMembers()) {
            System.out.println(member);
        }
        System.out.println("\n=== BOOKS ===");
        for (Book book : cityLibrary.getBooks()) {
            System.out.println(book);
        }
        System.out.println("\n=== ACTIVE LOANS ===");
        for (Loan loan : cityLibrary.getLoans()) {
            System.out.println(loan);
        }
    }
}