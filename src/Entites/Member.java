package Entites;

public class Member {
    package Entites;
import java.util.ArrayList;

    public class Member {
        private String memberId;
        private  String name;
        private Address address;

        private ArrayList<LibraryItem>borrowedItems;

        public Member(String memberId, String name, Address address){
            this.memberId = memberId;
            this.name= name;
            this.address= address;
            this.borrowedItems =new  ArrayList<>();

        }

        public String getMemberId() {

            return memberId;
        }

        public String getName() {
            return name;
        }

        public String getFullContactDetails(){
            return  "Member:" + name+ "(ID:" + memberId + ")\nAddress: " + address.getFullAddress();
        }

        public void borrowItem (LibraryItem item){
            borrowedItems.add(item);
        }

        public void returnItem (LibraryItem item){
            borrowedItems.remove(item);
        }

        public ArrayList<LibraryItem>getBorrowedItems(){
            return borrowedItems;
        }
    }
}
