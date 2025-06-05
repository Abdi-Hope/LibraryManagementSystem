import java.time.LocalDate;
import java.util.Scanner;
import model.Author;
import model.Book;
import model.Librarian;
import model.Library;
import model.Loan;
import model.Member;


public class Main {
    public static void main(String[] args) {
        // Create a library
       Scanner scanner = new Scanner(System.in);
        // Create a library
       System.out.println("Welcome to the Library Management System!");
            System.out.println("Please enter the name of the library:");
            String libraryName = scanner.nextLine();
            
            System.out.println("Please enter the address of the library:");
            String libraryAddress = scanner.nextLine();
            
            System.out.println("Please enter the phone number of the library:");
            String libraryPhone = scanner.nextLine();
            
            System.out.println("Please enter the email of the library:");
            String libraryEmail = scanner.nextLine();
            

            // Print the phone number and email to use the variables and avoid the warning
            System.out.println("Library phone number: " + libraryPhone);
            System.out.println("Library email: " + libraryEmail);
            System.out.println("libraryAddress: " + libraryAddress);
            System.out.println("libbraryPhone: " + libraryPhone);
            System.out.println("libraryEmail: " + libraryEmail);

            // Create the library instance
            Library cityLibrary = new Library(libraryName, libraryAddress);

        // Create a librarian
        System.out.println("Please enter the librarian's staff ID:");
        String staffId = scanner.nextLine();
        
        System.out.println("Please enter the librarian's name:");
        String librarianName = scanner.nextLine();
        
        System.out.println("Please enter the librarian's contact information:");
        String librarianContact = scanner.nextLine();
        
        Librarian headLibrarian = new Librarian(staffId, librarianName, librarianContact);

        // Add some authors
        System.out.println("enter author1 name:");
        String authorName1 = scanner.nextLine();
        
        System.out.println("enter author1 description:");
        String authorDescription1 = scanner.nextLine();
        
        System.out.println("enter author2 name:");
        String authorName2 = scanner.nextLine();
        
        System.out.println("enter author2 description:");
        String authorDescription2 = scanner.nextLine();
        
        Author author1 = new Author(authorName1, authorDescription1);
        Author author2 = new Author(authorName2, authorDescription2);
        // Add some books
        System.out.println("Please enter the ISBN for book1:");
        String isbn1 = scanner.nextLine();
        
        System.out.println("Please enter the title for book1:");
        String title1 = scanner.nextLine();
        
Book book1 = new Book(isbn1, title1, author1);
headLibrarian.addBookToLibrary(cityLibrary, book1);
System.out.println("Please enter the ISBN for book2:");
String isbn2 = scanner.nextLine();

System.out.println("Please enter the title for book2:");
String title2 = scanner.nextLine();

Book book2 = new Book(isbn2, title2, author2);
headLibrarian.addBookToLibrary(cityLibrary, book2);
System.out.println("Books added to the library successfully!");

        // Register some members
        System.out.println("enter member1 name:");
        String memberName1 = scanner.nextLine();
        
        System.out.println("enter member1 contact:");
        String memberContact1 = scanner.nextLine();
        
        System.out.println("enter member1 contactinfo:");
        String memberContactInfo1 = scanner.nextLine();
        
        System.out.println("enter member2 name:");
        String memberName2 = scanner.nextLine();
        
        System.out.println("enter member2 contact:");
        String memberContact2 = scanner.nextLine();
        
        System.out.println("enter member2 contactinfo:");
        String memberContactInfo2 = scanner.nextLine();
        

        // You may need to provide a member ID or email as the third argument, adjust as needed
        Member member1 = new Member(memberName1, memberContact1, memberContactInfo1);
        Member member2 = new Member(memberName2, memberContact2, memberContactInfo2);
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
            // Close the scanner to avoid resource leak
            scanner.close();
        }
    }
}