package services;

import Entites.LibraryItem;
import Entites.Member;

public class BorrowingService {
    private LibraryService libraryService;
    private MemberService memberService;

    public BorrowingService(LibraryService libraryService, MemberService memberService) {
        this.libraryService = libraryService;
        this.memberService = memberService;
    }

    public void borrowItem(String memberId, String itemId) {
        Member member = memberService.findMemberById(memberId);
        LibraryItem item = libraryService.findItemById(itemId);

        if (member == null) {
            System.out.println("Error: Member not found!");
            return;
        }

        if (item == null) {
            System.out.println("Error: Item not found!");
            return;
        }

        if (!item.isAvailable()) {
            System.out.println("Error: Item is already borrowed!");
            return;
        }

        item.setAvailable(false);
        member.borrowItem(item);
        System.out.println("Item " + item.getTitle() + " borrowed successfully by " + member.getName());



    }

    public void returnItem(String memberId, String itemId) {
        Member member = memberService.findMemberById(memberId);
        LibraryItem item = libraryService.findItemById(itemId);

        if (member != null && item != null) {
            item.setAvailable(true);
            member.returnItem(item);
            System.out.println("Item " + item.getTitle() + " returned successfully.");
        } else {
            System.out.println("Error: Could not process return. Check IDs.");
        }
    }
}
