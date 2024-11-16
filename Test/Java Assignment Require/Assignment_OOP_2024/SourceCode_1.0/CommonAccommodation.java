import java.util.ArrayList;

public class CommonAccommodation extends Accommodation {
   protected ArrayList<Room> rooms;
   protected float rating_Coefficient;

   public CommonAccommodation(int iD_Accommodation, String name_Accommodation, String address_Accommodation,
         String city_Accommodation, ArrayList<Room> rooms, float rating_Coefficient) {
      super(iD_Accommodation, name_Accommodation, address_Accommodation, city_Accommodation);
      this.rooms = rooms;
      this.rating_Coefficient = rating_Coefficient;
   }

   public CommonAccommodation(int iD_Accommodation, String name_Accommodation, String address_Accommodation,
         String city_Accommodation, float rating_Coefficient) {
      super(iD_Accommodation, name_Accommodation, address_Accommodation, city_Accommodation);
      this.rooms = new ArrayList<>();
      this.rating_Coefficient = rating_Coefficient;
   }

   public ArrayList<Room> getRooms() {
      return rooms;
   }

   public void setRooms(ArrayList<Room> rooms) {
      this.rooms = rooms;
   }

   public float getRating_Coefficient() {
      return rating_Coefficient;
   }

   public void setRating_Coefficient(float rating_Coefficient) {
      this.rating_Coefficient = rating_Coefficient;
   }

}
