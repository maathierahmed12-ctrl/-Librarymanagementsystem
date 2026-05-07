import services.*;
import Menu.LibraryMenu;

public class main {
    public static void main(String[] args) {

        LibraryService libraryService = new LibraryService();
        MemberService memberService = new MemberService();
        BorrowingService borrowingService = new BorrowingService(libraryService, memberService);


        LibraryMenu menu = new LibraryMenu(libraryService, memberService, borrowingService);
        menu.start();
    }
}