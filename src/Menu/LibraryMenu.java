package Menu;

import services.*;
import Entites.*;
import java.util.Scanner;

public class LibraryMenu {
    private LibraryService libraryService;
    private MemberService memberService;
    private BorrowingService borrowingService;
    private Scanner scanner;

    public LibraryMenu(LibraryService libService, MemberService memService, BorrowingService borrowService) {
        this.libraryService = libService;
        this.memberService = memService;
        this.borrowingService = borrowService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("*** Library Management System ***");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. List All Items");
            System.out.println("4. Register Member");
            System.out.println("5. List All Members");
            System.out.println("6. Borrow Item");
            System.out.println("7. Return Item");
            System.out.println("8. Add DVD");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMagazine();
                    break;
                case 3:
                    libraryService.listAvailableItems();
                    break;
                case 4:
                    addMember();
                    break;
                case 5:
                    memberService.listAllMembers();
                    break;
                case 6:
                    borrowProcess();
                    break;
                case 7:
                    returnProcess();
                    break;
                case 8 :
                    addDVD();
                    break;
                case 9:
                    System.out.println("Closing System...");
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        libraryService.addItem(new Book(id, title, author));
        System.out.println("Book added!");
    }

    private void addMagazine() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Issue Number: ");
        int issue = scanner.nextInt();
        scanner.nextLine();

        libraryService.addItem(new Magazine(id, title, issue));
        System.out.println("Magazine added successfully!");
    }

    private void addMember() {
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        System.out.print("Enter Street: ");
        String street = scanner.nextLine();

        Address address = new Address(street, city);
        memberService.registerMember(new Member(id, name, address));
        System.out.println("Member registered!");
    }

    private void borrowProcess() {
        System.out.print("Enter Member ID: ");
        String mId = scanner.nextLine();
        System.out.print("Enter Item ID: ");
        String iId = scanner.nextLine();
        borrowingService.borrowItem(mId, iId);
    }

    private void returnProcess() {
        System.out.print("Enter Member ID: ");
        String mId = scanner.nextLine();
        System.out.print("Enter Item ID to return: ");
        String iId = scanner.nextLine();


        borrowingService.returnItem(mId, iId);
    }

    private void addDVD() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Duration (mins): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        libraryService.addItem(new DVD(id, title, duration));
        System.out.println("DVD added!");
    }
}
