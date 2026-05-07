package services;
import java.util.ArrayList;
import Entites.LibraryItem;

public class LibraryService {
    private ArrayList<LibraryItem> items = new ArrayList<>();

    public void addItem (LibraryItem item){
        items.add(item);
    }
    public void searchByTitle (String title){
        for (LibraryItem item : items){
            if (item.getTitle().toLowerCase().contains(title.toLowerCase())){

                System.out.println(item.getDetails());
            }
        }
    }

    public void listAvailableItems(){
        for (LibraryItem item: items){
            if (item.isAvailable()){
                System.out.println(item.getDetails());
            }
        }
    }

    public LibraryItem findItemById(String id){
        for (LibraryItem item : items){
            if(item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }
}