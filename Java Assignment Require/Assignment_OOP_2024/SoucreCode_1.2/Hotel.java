import java.util.ArrayList;

public class Hotel extends CommonAccommodation {
    private int rating_stars_Hotel;

    // full constructor
    public Hotel(int iD_Accommodation, String name_Accommodation, String address_Accommodation,
            String city_Accommodation, ArrayList<Room> rooms, float rating_Coefficient, int rating_stars_Hotel) {
        super(iD_Accommodation, name_Accommodation, address_Accommodation, city_Accommodation, rooms,
                rating_Coefficient);
        this.rating_stars_Hotel = rating_stars_Hotel;
    }

    // constructor without rooms list
    public Hotel(int iD_Accommodation, String name_Accommodation, String address_Accommodation,
            String city_Accommodation, float rating_Coefficient, int rating_stars_Hotel) {
        super(iD_Accommodation, name_Accommodation, address_Accommodation, city_Accommodation, rating_Coefficient);
        this.rating_stars_Hotel = rating_stars_Hotel;
    }

    // getters and setters
    public int getRating_stars_Hotel() {
        return rating_stars_Hotel;
    }

    public void setRating_stars_Hotel(int rating_stars_Hotel) {
        this.rating_stars_Hotel = rating_stars_Hotel;
    }
    
    @Override
    public String toString() {
        return "Hotel [" + ID_Accommodation + ", " + rating_stars_Hotel
                + ", " + name_Accommodation + ", " + address_Accommodation
                + ", " + city_Accommodation + "]";
    }

    
}
