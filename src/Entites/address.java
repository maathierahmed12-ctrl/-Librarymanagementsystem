package Entites;

public class address {

    private String Street;
    private String city;
    private String zipcode;

    public address(String street , String city){
        this.Street=street;
        this.city=city;
        this.zipcode=zipcode;
    }
    public String getStreet(){
        return Street;
    }
    public String getCity(){
        return city;
    }
    public String getZipcode(){
        return zipcode;
    }
    public  String getFullAddress() {

        return street + " ," + city + " ," + zipcode;
    }
}

