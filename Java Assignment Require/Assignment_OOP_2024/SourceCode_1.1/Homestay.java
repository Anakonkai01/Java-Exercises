import java.util.ArrayList;

public class Homestay extends CommonAccommodation {

    public Homestay(int iD_Accommodation, String name_Accommodation, String address_Accommodation,
            String city_Accommodation, ArrayList<Room> rooms, float rating_Coefficient) {
        super(iD_Accommodation, name_Accommodation, address_Accommodation, city_Accommodation, rooms, rating_Coefficient);
    }
    
    public Homestay(int iD_Accommodation, String name_Accommodation, String address_Accommodation,
            String city_Accommodation, float rating_Coefficient) {
        super(iD_Accommodation, name_Accommodation, address_Accommodation, city_Accommodation, rating_Coefficient);
    }

    @Override
    public String toString() {
        return "Homestay ["+ID_Accommodation+", "+name_Accommodation+", "
                        +address_Accommodation+", "+getRating_Coefficient()+", "+city_Accommodation+"]";
    }
}
