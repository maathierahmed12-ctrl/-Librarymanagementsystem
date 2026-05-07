package Entites;
public  class Book extends LibraryItem {

    private String author;

    public Book(String id , String title , String author){

        super(id , title);
        this.author=author;
    }
    public String getDetails(){
        return "Book Details : ID = " + getid() + "," + "." + "Title = + getTitle() + ", "Author = " + author + ", status =" + (isAvailable()? "Available" : "Borrowed");    }
}



